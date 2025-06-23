package CoffeeVendingMachine;

import java.util.HashMap;
import java.util.Map;

// Inventory
public class IngredientStore {
    private final Map<String, Integer> inventory = new HashMap<>();
    private final Map<String, Integer> limitMap = new HashMap<>();

    // Refill ingredient stock (thread-safe)
    public synchronized void refill(String ingredient, int qty) {
        inventory.put(ingredient, inventory.getOrDefault(ingredient, 0) + qty);
    }

    // Limit > for alert
    public synchronized void setAlert(String ingredient, int qty) {
        limitMap.put(ingredient, qty);
    }

    // Check if all required ingredients are available
    public synchronized boolean hasEnough(Map<String, Integer> required) {
        for (String ingredient : required.keySet()) {
            if (inventory.getOrDefault(ingredient, 0) < required.get(ingredient)) {
                return false;
            }
        }
        return true;
    }

    // Consume required ingredients
    public synchronized void consume(Map<String, Integer> required) {
        for (String ingredient : required.keySet()) {
            inventory.put(ingredient, inventory.get(ingredient) - required.get(ingredient));

            // Check and notify each ingredient
            checkAndNotify(ingredient);
        }
    }

    private void checkAndNotify(String ingredient) {
        if (inventory.getOrDefault(ingredient, 0) < limitMap.getOrDefault(ingredient, 0)) {
            // notify
            CoffeeVendingMachine.getInstance().showAlert(ingredient);
        }
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}