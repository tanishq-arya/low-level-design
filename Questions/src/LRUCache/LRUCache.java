package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    // Functional requirements
    // 1. Distributed
    // 2. Read / Write

    // Non-Functional Requirements
    // 1. Highly available
    // 2. Highly scalable
    // 3. Performance > O(1)

    // Question > Consistency ?
    // Answer using CAP Theorem

    private final int size;
    private final Map<K, Node<K,V>> map = new HashMap<>();
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int size) {
        this.size = size;
        this.head = new Node<K,V>(null, null);
        this.tail = new Node<K,V>(null, null);

        head.next = tail;
        tail.prev = head;
    }

    // Methods
    // insert
    public synchronized void insert(K key, V value) {
        // check if key exists
        // - no > insert
        // - no > cache full > LRU algorithm **
        // - yes > update value and reorder [doubly linked list]
        Node<K, V> node = map.get(key);
        if (node == null) {
            if (map.size() == size){ // cache full - LRU and insert
                removeTail();// remove tail
            }
            // add new Node to head
            node = new Node<>(key, value);
            addToHead(node);
            map.put(key, node);
        } else { // already has the node
            node.value = value;
            moveToHead(node); // remove and add to head
        }

//        System.out.println("Map: " + map);
    }

    private void removeTail() {
        Node<K,V> lruNode = tail.prev;
        map.remove(lruNode.key);
        removeNode(tail.prev);
    }

    public synchronized V retrieve(K key) {
        Node<K,V> res = map.get(key);
        if (res != null) {
            moveToHead(res);
            return res.value;
        }
        return null; // not in map
    }

    private void moveToHead(Node<K,V> node) { // remove and add to head
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}