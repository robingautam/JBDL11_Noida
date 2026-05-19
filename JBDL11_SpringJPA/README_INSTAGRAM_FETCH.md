Instagram fetch posts helper

Usage
-----

1. Create a Python virtualenv and install requirements:

```bash
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt
```

2. Run the script with a username:

```bash
python instagram_fetch_posts.py coding_knowladge
```

Notes
-----
- Instagram often requires authentication for many API endpoints. For public profiles, some data is available without login but not guaranteed.
- If Instagram blocks access or returns unexpected structure, inspect `response.txt` and/or use developer tools to see the exact GraphQL query performed by your browser.
- The script tries several strategies: public JSON (?__a=1), HTML -> GraphQL query_id, and private feed endpoint fallback. Provide valid session cookies if necessary.

Security and terms
------------------
- Be careful scraping Instagram; follow their terms of service and avoid abusive scraping.

