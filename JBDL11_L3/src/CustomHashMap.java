import java.util.Iterator;
import java.util.LinkedList;

public class CustomHashMap<K,V> {

    private LinkedList<Node<K,V>>[] BUCKET_ARRAY ;

    static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;
        Node(K k, V v){
           this.key = k;
           this.value = v;
           this.next = null;
        }
        Node(){}
    }

    CustomHashMap(){
        BUCKET_ARRAY = new LinkedList[16];
    }

    public void put(K k, V v){
        int index = getBucketIndex(k);
        LinkedList<Node<K,V>> linkedList = BUCKET_ARRAY[index];
        if (linkedList==null){
            LinkedList<Node<K,V>> init = new LinkedList<>();
            init.add(new Node<>(k,v));
            BUCKET_ARRAY[index] = init;
        }else {
           Iterator<Node<K,V>> iterator = linkedList.iterator();
           while (iterator.hasNext()){
               Node<K,V> next = iterator.next();
               if (next.key.equals(k)){
                   next.value = v;
                   break;
               }
           }
           linkedList.add(new Node(k,v));
        }
    }

    public int getBucketIndex(K k){
        int hashcode = k.hashCode();
        return hashcode%BUCKET_ARRAY.length;
    }
}
