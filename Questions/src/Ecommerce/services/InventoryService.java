package Ecommerce.services;

import Ecommerce.models.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    // Concurrent hashmap
    Map<Long, Inventory> inventoryMap = new ConcurrentHashMap<>(); // product -> qty mappings

    synchronized boolean reserveInventory(Long productId, int qty) {
        Inventory inv = inventoryMap.get(productId);

        if (inv.getRemainingStock() < qty) { // cannot reserve
            return false;
        }

        inv.reservedQty += qty; // reserve current qty
        return true;
    }
}
