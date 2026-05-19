#!/usr/bin/env python3
"""
instagram_fetch_posts.py

Usage:
    python instagram_fetch_posts.py USERNAME

What it does:
- Fetches the Instagram profile page for USERNAME.
- Attempts multiple strategies to obtain the user's posts:
  1) Public JSON endpoint: https://www.instagram.com/{username}/?__a=1&__d=dis
  2) GraphQL query using a query_id/query_hash and user_id discovered in the profile HTML
  3) Private-style feed endpoint fallback: /api/v1/feed/user/{username}/username/
- Parses the response and prints post page URLs and direct media URLs (images/videos).

Notes:
- Instagram frequently changes internals and may require authentication/cookies for some endpoints.
- If you have a logged-in session, set cookies in the session or run the script from an environment
  where requests.Session() has the necessary cookies.

Dependencies: requests, beautifulsoup4

"""

import argparse
import json
import re
import sys
from urllib.parse import quote

import requests
from bs4 import BeautifulSoup


HEADERS = {
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/115.0 Safari/537.36',
    'Accept-Language': 'en-US,en;q=0.9'
}


def load_cookies_from_string(cookie_str):
    """Parse a cookie header string like 'name=value; name2=value2' into a dict."""
    cookies = {}
    if not cookie_str:
        return cookies
    parts = [p.strip() for p in cookie_str.split(';') if p.strip()]
    for p in parts:
        if '=' in p:
            k, v = p.split('=', 1)
            cookies[k.strip()] = v.strip()
    return cookies


def load_cookies_from_file(path):
    """Load cookies from a JSON file containing a dict of name->value pairs."""
    try:
        with open(path, 'r', encoding='utf-8') as f:
            data = json.load(f)
            if isinstance(data, dict):
                return data
    except Exception:
        pass
    return {}


def fetch_profile_html(session, username):
    url = f'https://www.instagram.com/{username}/'
    r = session.get(url, headers=HEADERS)
    r.raise_for_status()
    return r.text, r.url


def try_query_a1(session, username):
    """Try the ?__a=1 JSON shortcut used by Instagram web (may be rate-limited or require auth)."""
    # Try two common variations
    for suffix in ['?__a=1&__d=dis', '?__a=1']:
        url = f'https://www.instagram.com/{username}/{suffix}'
        r = session.get(url, headers=HEADERS)
        if r.status_code != 200:
            continue
        try:
            return r.json()
        except Exception:
            continue
    return None


def extract_query_and_userid(html, username=None):
    """Search the HTML for a query_id / query_hash and user_id which are commonly embedded in bootstrapped JSON.

    Heuristics used (in order):
    1) Look for a 'query' object that contains both query_id and user_id (common in preloader blocks).
    2) query_id: "query_id": "digits"
    3) query_hash: "query_hash" or "queryHash"
    4) user id by locating the username and finding the nearby "id": "digits"
    5) fallback: any 'user' object with an 'id' value or PolarisViewer block
    """
    query_id = None
    query_hash = None
    user_id = None

    # 1) Try to find a 'query' block that contains both query_id and user_id (covers many preloader blocks)
    m = re.search(r'"query"\s*:\s*\{([^}]+)\}', html, re.DOTALL)
    if m:
        block = m.group(1)
        qi = re.search(r'"query_id"\s*:\s*"(\d+)"', block)
        ui = re.search(r'"user_id"\s*:\s*"(\d+)"', block)
        if qi and ui:
            query_id = qi.group(1)
            user_id = ui.group(1)

    # 2) search for query_id anywhere if not found above
    if not query_id:
        q_m = re.search(r'"query_id"\s*:\s*"(\d+)"', html)
        if q_m:
            query_id = q_m.group(1)

    # 3) search for query_hash (hex or alnum)
    qh_m = re.search(r'"query_hash"\s*:\s*"([0-9a-fA-F]+)"', html)
    if not qh_m:
        qh_m = re.search(r'"queryHash"\s*:\s*"([0-9a-fA-F]+)"', html)
    if qh_m:
        query_hash = qh_m.group(1)

    # 4) find user id associated with username (search within a window) if still missing
    if username and not user_id:
        uname = re.escape(username)
        m2 = re.search(rf'"username"\s*:\s*"{uname}"(.{{0,1000}}?)"id"\s*:\s*"(\d+)"', html)
        if m2:
            user_id = m2.group(2)

    # 5) fallback: look for patterns like 'user': {... 'id': '...'}
    if not user_id:
        m3 = re.search(r'"user"\s*:\s*\{([^\}}]{{0,800}}?)\}', html)
        if m3:
            id_m = re.search(r'"id"\s*:\s*"(\d+)"', m3.group(1))
            if id_m:
                user_id = id_m.group(1)

    # 6) fallback: PolarisViewer block
    if not user_id:
        m4 = re.search(r'PolarisViewer[\s\S]{0,400}"id"\s*:\s*"(\d+)"', html)
        if m4:
            user_id = m4.group(1)

    return query_id, query_hash, user_id


def call_graphql_query(session, profile_url, query_id=None, query_hash=None, user_id=None, first=12):
    """Call the GraphQL query endpoint using either query_id or query_hash and user_id.

    - If query_id is provided, use ?query_id=...&user_id=...
    - If query_hash is provided, use ?query_hash=...&variables=... (variables is JSON)
    """
    url = 'https://www.instagram.com/graphql/query/'
    headers = HEADERS.copy()
    headers['Referer'] = profile_url
    headers['X-Requested-With'] = 'XMLHttpRequest'
    if 'csrftoken' in session.cookies:
        headers['X-CSRFToken'] = session.cookies.get('csrftoken')

    params = {}
    if query_id:
        params['query_id'] = query_id
        if user_id:
            params['user_id'] = user_id
        params['include_reel'] = 'true'
    elif query_hash and user_id:
        params['query_hash'] = query_hash
        variables = {'id': user_id, 'first': first}
        params['variables'] = json.dumps(variables)
    else:
        return None

    r = session.get(url, params=params, headers=headers)
    if r.status_code != 200:
        return None
    try:
        return r.json()
    except Exception:
        return None


def parse_graphql_posts(data):
    """Parse GraphQL response to extract post nodes (list of node dicts)."""
    nodes = []
    if not data:
        return nodes
    # Common path: data -> user -> edge_owner_to_timeline_media -> edges
    try:
        user = data.get('data', {}).get('user')
        if user:
            em = user.get('edge_owner_to_timeline_media') or user.get('edge_owner_to_timeline_media')
            if em and 'edges' in em:
                for edge in em['edges']:
                    node = edge.get('node')
                    if node:
                        nodes.append(node)
                return nodes
    except Exception:
        pass

    # Some GraphQL responses put posts at a different path; try several heuristics
    try:
        # data -> user -> timeline_media -> edges
        em = data.get('data', {}).get('user', {}).get('timeline_media')
        if em and 'edges' in em:
            for edge in em['edges']:
                node = edge.get('node')
                if node:
                    nodes.append(node)
            return nodes
    except Exception:
        pass

    return nodes


def parse_a1_json_posts(a1json):
    """Parse the /?__a=1 JSON if available. Returns list of node dicts."""
    nodes = []
    if not a1json:
        return nodes
    # Many variants exist. Try the 'graphql' path
    g = a1json.get('graphql') or a1json.get('data')
    if not g:
        return nodes
    user = g.get('user')
    if user:
        em = user.get('edge_owner_to_timeline_media')
        if em and 'edges' in em:
            for edge in em['edges']:
                node = edge.get('node')
                if node:
                    nodes.append(node)
    return nodes


def parse_private_feed(json_data):
    """Parse private API feed user response (items array)."""
    nodes = []
    if not json_data:
        return nodes
    # Typical key: 'items'
    items = json_data.get('items') or json_data.get('media') or json_data.get('payload')
    if isinstance(items, list):
        for item in items:
            nodes.append(item)
    return nodes


def extract_media_from_node(node):
    """Given a node (graphQL or private) return a list of media URLs and the post page URL (if shortcode exists)."""
    media_urls = []
    post_url = None
    # shortcode -> post URL
    shortcode = node.get('shortcode') or node.get('code')
    if shortcode:
        post_url = f'https://www.instagram.com/p/{shortcode}/'

    # GraphQL style image/video
    # image: display_url or display_resources
    display_url = node.get('display_url')
    if display_url:
        media_urls.append(display_url)

    # display_resources is a list of resources
    dr = node.get('display_resources') or node.get('display_src')
    if isinstance(dr, list):
        # pick highest-res (last)
        for r in dr:
            url = r.get('src') or r.get('url')
            if url and url not in media_urls:
                media_urls.append(url)

    # Private API image candidates
    img_versions = node.get('image_versions2') or node.get('carousel_media')
    if isinstance(img_versions, dict):
        cands = img_versions.get('candidates')
        if isinstance(cands, list):
            for cand in cands:
                url = cand.get('url')
                if url and url not in media_urls:
                    media_urls.append(url)

    # Video
    if node.get('is_video') or node.get('media_type') == 2:
        # try multiple fields for video URL
        v_url = node.get('video_url') or node.get('video_versions')
        if isinstance(v_url, str):
            media_urls.append(v_url)
        elif isinstance(v_url, list):
            # choose largest by width if available
            best = None
            best_w = -1
            for v in v_url:
                url = v.get('url') or v.get('src')
                w = v.get('width') or 0
                if url and w > best_w:
                    best = url
                    best_w = w
            if best and best not in media_urls:
                media_urls.append(best)

    # Carousel (GraphQL uses edge_sidecar_to_children)
    sidecar = node.get('edge_sidecar_to_children') or node.get('carousel_media')
    if isinstance(sidecar, dict):
        edges = sidecar.get('edges') or sidecar.get('items')
        if isinstance(edges, list):
            for child in edges:
                child_node = child.get('node') if isinstance(child, dict) and 'node' in child else child
                if isinstance(child_node, dict):
                    # recursive extraction for child
                    child_media, _ = extract_media_from_node(child_node)
                    for m in child_media:
                        if m not in media_urls:
                            media_urls.append(m)

    # Private carousel_media list
    if isinstance(node.get('carousel_media'), list):
        for cm in node.get('carousel_media'):
            # cm may be { 'image_versions2': { 'candidates': [...] } }
            if isinstance(cm, dict):
                iv = cm.get('image_versions2')
                if iv and 'candidates' in iv:
                    for cand in iv['candidates']:
                        url = cand.get('url')
                        if url and url not in media_urls:
                            media_urls.append(url)
                # videos
                vv = cm.get('video_versions')
                if isinstance(vv, list):
                    for v in vv:
                        url = v.get('url')
                        if url and url not in media_urls:
                            media_urls.append(url)

    return media_urls, post_url


def main():
    p = argparse.ArgumentParser(description='Fetch Instagram posts media URLs for a username')
    p.add_argument('username', help='Instagram username')
    p.add_argument('--count', type=int, default=12, help='Number of posts to request (where supported)')
    p.add_argument('--cookies', help="Cookie header string like 'sessionid=...; csrftoken=...' to use for requests")
    p.add_argument('--cookie-file', help='Path to JSON file with cookie name->value mapping')
    p.add_argument('--dry-run', action='store_true', help='Only extract and print query_id, query_hash, user_id without fetching posts')
    p.add_argument('--local-file', help='Path to a local HTML file to parse (bypasses network fetch)')
    args = p.parse_args()

    session = requests.Session()
    session.headers.update(HEADERS)

    # Load cookies if provided
    if args.cookies:
        c = load_cookies_from_string(args.cookies)
        session.cookies.update(c)
    if args.cookie_file:
        cf = load_cookies_from_file(args.cookie_file)
        session.cookies.update(cf)

    username = args.username
    try:
        # 0) quick try: ?__a=1 JSON (only when not using local file)
        a1 = None
        if not args.local_file:
            a1 = try_query_a1(session, username)
        if a1:
            print('[+] Retrieved public JSON via ?__a=1')
            nodes = parse_a1_json_posts(a1)
            if nodes:
                for node in nodes[: args.count]:
                    media_urls, post_url = extract_media_from_node(node)
                    print('POST:', post_url or '(no post url)')
                    for m in media_urls:
                        print('  ', m)
                return

        # 1) obtain profile HTML: from local file if provided, else fetch
        if args.local_file:
            try:
                with open(args.local_file, 'r', encoding='utf-8') as f:
                    html = f.read()
                profile_url = 'file://' + args.local_file
                print(f'[+] Loaded local HTML from: {args.local_file}')
            except Exception as e:
                print('[!] Failed to read local file:', e)
                sys.exit(1)
        else:
            html, profile_url = fetch_profile_html(session, username)
            print('[+] Fetched profile HTML:', profile_url)

        # try to extract query and user id
        query_id, query_hash, user_id = extract_query_and_userid(html, username)
        if (query_id or query_hash) and user_id:
            print('[+] Found identifiers:')
            if query_id:
                print('  query_id:', query_id)
            if query_hash:
                print('  query_hash:', query_hash)
            print('  user_id:', user_id)

            if args.dry_run:
                print('[+] --dry-run enabled, not fetching posts.')
                return

            # prefer query_hash (modern) if available
            gql = call_graphql_query(session, profile_url, query_id=query_id, query_hash=query_hash, user_id=user_id, first=args.count)
            nodes = parse_graphql_posts(gql)
            if nodes:
                for node in nodes[: args.count]:
                    media_urls, post_url = extract_media_from_node(node)
                    print('POST:', post_url or '(no post url)')
                    for m in media_urls:
                        print('  ', m)
                return
            else:
                print('[!] GraphQL returned no nodes (or failed to parse)')
        else:
            print('[!] query_id/query_hash and user_id not both found in HTML — attempting private feed endpoint')

        # 2) Fallback: try private feed endpoint (may require auth)
        private_feed_url = f'https://www.instagram.com/api/v1/feed/user/{username}/username/'
        params = {'count': args.count}
        r = session.get(private_feed_url, params=params, headers={'Referer': profile_url})
        if r.status_code == 200:
            try:
                json_data = r.json()
                nodes = parse_private_feed(json_data)
                if nodes:
                    for node in nodes[: args.count]:
                        media_urls, post_url = extract_media_from_node(node)
                        print('POST:', post_url or '(no post url)')
                        for m in media_urls:
                            print('  ', m)
                    return
            except Exception:
                pass
        else:
            print(f'[!] Private feed endpoint returned status {r.status_code} — may require authentication')

        print('[!] Unable to fetch posts from the available endpoints. Instagram may require authentication or the page structure has changed.')

    except requests.HTTPError as e:
        print('[!] HTTP error:', e, file=sys.stderr)
        sys.exit(1)
    except Exception as e:
        print('[!] Unexpected error:', e, file=sys.stderr)
        sys.exit(1)


if __name__ == '__main__':
    main()

