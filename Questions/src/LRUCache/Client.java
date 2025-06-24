package LRUCache;

import java.net.Inet4Address;

public class Client {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<Integer, String>(3);

        cache.insert(1, "Value 1");
        cache.insert(2, "Value 2");
        cache.insert(3, "Value 3");

        System.out.println(cache.retrieve(1)); // Output: Value 1
        System.out.println(cache.retrieve(2)); // Output: Value 2

        cache.insert(4, "Value 4");

        System.out.println(cache.retrieve(3)); // Output: null
        System.out.println(cache.retrieve(4)); // Output: Value 4

        cache.insert(2, "Updated Value 2");

        System.out.println(cache.retrieve(1)); // Output: Value 1
        System.out.println(cache.retrieve(2)); // Output: Updated Value 2
    }
}