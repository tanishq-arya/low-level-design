package VendingMachine.SessionPattern;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    // Quantity Map
    private Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity (T item) {
        return inventory.getOrDefault(item, 0);
    }

    // Add product
    public void add(T item) {
        inventory.put(item, getQuantity(item)+1);
    }

    // Restocking - we may add large qty
    public void add(T item, int qty) {
        inventory.put(item, getQuantity(item) + qty);
    }

    // Check if item is available
    public boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }

    // Remove product
    public void remove(T item) {
        if (hasItem(item)) {
            inventory.put(item, getQuantity(item) - 1);
        }
    }

    public void clear() {
        inventory.clear();
    }

    // Fetch full inventory
    public Map<T, Integer> getInventory() {
        return inventory;
    }
}