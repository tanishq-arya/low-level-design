package LRUCache;

public class Node<K, V> {
    K key;
    V value;
    Node<K,V> prev;
    Node<K,V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}