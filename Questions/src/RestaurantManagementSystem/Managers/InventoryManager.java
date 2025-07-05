package RestaurantManagementSystem.Managers;

import RestaurantManagementSystem.Ingredient;
import RestaurantManagementSystem.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    // Flyweight pattern ?
    public InventoryManager() {
        initialize();
    }

    private void initialize() {
        Ingredient cheese = new Ingredient("I1", "Cheese", 10, "slices");
        Ingredient dough  = new Ingredient("I2", "Dough", 5, "bases");
        Ingredient tomato = new Ingredient("I3", "Tomato Sauce", 8, "cups");
        Ingredient lettuce= new Ingredient("I4", "Lettuce", 5, "heads");
    }

    private final Map<String, Ingredient> stock = new HashMap<>();

    public void addIngredient(Ingredient ingredient) {
        stock.put(ingredient.getId(), ingredient);
    }

    public boolean checkAvailability(List<MenuItem> items) {
        for (MenuItem item : items) {
            for (Ingredient ing : item.getIngredients()) {
                if (stock.get(ing.getId()).getQuantityInStock() < /* required qty */ 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void deductForOrder(List<MenuItem> items) {
        for (MenuItem item : items) {
            for (Ingredient ing : item.getIngredients()) {
                stock.get(ing.getId()).deduct(1); // assume qty=1 per item
            }
        }
    }
    public void replenish(String ingId, int qty) {
        stock.get(ingId).replenish(qty);
    }
}