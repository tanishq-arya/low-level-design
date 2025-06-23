package CoffeeVendingMachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeVendingMachine {
    private static CoffeeVendingMachine instance; // Singleton instance

    // resources
    private final Map<String, CoffeeRecipe> recipes = new HashMap<>();
    private final IngredientStore ingredientStore = new IngredientStore();
    private final PaymentProcessor paymentProcessor = new PaymentProcessor();
    private final Dispenser dispenser = new Dispenser();

    // private constructor
    private CoffeeVendingMachine() {
        loadDefaultRecipes();
    }

    private void loadDefaultRecipes() {
        System.out.println("Starting Machine. Loading default recipes...");
        recipes.put("Espresso", new CoffeeRecipe("Espresso", 2.5, Map.of("Water", 50, "CoffeeBeans", 20)));
        recipes.put("Latte", new CoffeeRecipe("Latte", 3.0, Map.of("Water", 50, "CoffeeBeans", 20, "Milk", 30)));
        recipes.put("Cappuccino", new CoffeeRecipe("Cappuccino", 3.5, Map.of("Water", 50, "CoffeeBeans", 20, "Milk", 40)));
    }

    public static CoffeeVendingMachine getInstance() {
        if(instance == null) {
            instance = new CoffeeVendingMachine();
        }
        return instance;
    }

    /** Show menu of available coffees */
    public void displayMenu() {
        System.out.println("==== Coffee Menu ====");
        recipes.values().forEach(recipe ->
            System.out.printf("%s: $%.2f%n", recipe.getName(), recipe.getPrice())
        );
        System.out.print("\n");
    }

    /** Select a recipe by name */
    public CoffeeRecipe selectCoffee(String name) {
        CoffeeRecipe recipe = recipes.get(name);
        if (recipe == null) {
            throw new IllegalArgumentException("Unknown coffee: " + name);
        }
        return recipe;
    }

    // ** Main function > dispense
    public synchronized void dispenseCoffee(CoffeeRecipe recipe, Payment payment) {
        // 1. Check
        if (!ingredientStore.hasEnough(recipe.getIngredients())) {
            System.out.println("Insufficient ingredients for: " + recipe.getName());
            return;
        }

        // 2. Consume
        ingredientStore.consume(recipe.getIngredients());

        // 3. Brew
        dispenser.prepareDrink(recipe);

        // 4. Payment Return change
        double change = paymentProcessor.process(recipe.getPrice(), payment.getAmount());
        if (change > 0) {
            System.out.println("Please collect your change : $" + change);
        }
    }

    /** Refill a specific ingredient */
    public void refillIngredient(String ingredient, int qty) {
        ingredientStore.refill(ingredient, qty);
    }

    // SetAlert
    public void setIngredientAlert(String ingredient, int qty) {
        ingredientStore.setAlert(ingredient, qty);
    }

    /** Show current ingredient levels */
    public void showIngredients() {
        System.out.println("=== Ingredient Levels ===");
        ingredientStore.getInventory().forEach((k, v) ->
            System.out.printf("%s: %d%n", k, v)
        );
    }

    public void showAlert(String ingredient) {
        System.out.println("Alert!! Ingredients low on qty: " + ingredient);
        showIngredients();
    }
}