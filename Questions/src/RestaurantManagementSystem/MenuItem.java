package RestaurantManagementSystem;

import java.util.List;
import java.util.UUID;

public class MenuItem {
    private final String id;
    private final String name;
    private final double price;
    private final String category;
    // Can be stored as a map <Ingredient, Qty>
    private final List<Ingredient> ingredients;

    public MenuItem(String id, String name, double price, String category, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    // Simple check if all ingredients are present or not
    public boolean isAvailable() {
        return ingredients.stream().allMatch(i -> i.deduct(0));  // availability check
    }

    public double getPrice() {return this.price;}
    public List<Ingredient> getIngredients() {return this.ingredients;}
    public String getName() {return this.name;}
}