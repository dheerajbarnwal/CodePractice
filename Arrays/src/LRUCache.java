import java.util.*;

/**
 *
 */
class Node<K,V>{
    K key;
    V val;
    Node<K,V> next;
    Node<K,V> prev;
    Node(K k,V v){
        this.key = k;
        this.val = v;
    }
}
class LRUCacheHelper<K,V> {
    Map<K,Node<K,V>> hm;
    int cap;
    Node<K,V> head,tail;
    public LRUCacheHelper(int capacity) {
        head=tail=null;
        cap= capacity;
        hm = new HashMap<>();
    }

    public V get(K key) {
        if(hm.containsKey(key)){
            Node<K,V> node = hm.get(key);
            remove(node);
            setHead(node);
            return node.val;
        }
        return null;
    }

    public void put(K key, V value) {
        Node<K, V> node;
        if(hm.containsKey(key)){
            node = hm.get(key);
            node.val = value;
            remove(node);
        }else{
            node = new Node<K, V>(key, value);
            if(hm.size()==cap){
                //this order matters.First remove from map and then remove from linkedlist
                hm.remove(tail.key);
                remove(tail);
            }
            hm.put(key,node);
        }
        setHead(node);
    }
    void setHead(Node<K,V> node){
        node.prev=null;
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(tail==null){
            tail=node;
        }
    }
    void remove(Node<K,V> node){
        Node<K,V> prev = node.prev;
        Node<K,V> next = node.next;
        if(prev!=null){
            prev.next=next;
        }else{
            head = next;
        }
        if(next!=null){
            next.prev = prev;
        }else{
            tail=prev;
        }
    }
}
public class LRUCache{

    public static void main(String args[]){
        LRUCache l = new LRUCache();
        l.testMethod();
    }
    public void testMethod(){
        LRUCacheHelper<Integer,Integer> helper = new LRUCacheHelper<>(3);
        helper.put(1,1);
        helper.put(2,2);
        System.out.println(helper.get(1));
        helper.put(3,3);
        helper.put(4,4);
        System.out.println(helper.get(2));

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
