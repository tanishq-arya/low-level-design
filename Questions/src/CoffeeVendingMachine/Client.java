package CoffeeVendingMachine;

public class Client {
    public static void main(String[] args) {
        CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();

        // Refill ingredients
        machine.refillIngredient("Water", 200);
        machine.refillIngredient("CoffeeBeans", 100);
        machine.refillIngredient("Milk", 100);

        machine.setIngredientAlert("CoffeeBeans", 75);

        machine.displayMenu();
        machine.showIngredients();

        // Simulate concurrent orders
        Thread user1 = new Thread(() -> {
            CoffeeRecipe espresso = machine.selectCoffee("Espresso");
            machine.dispenseCoffee(espresso, new Payment(5.0));
        });

        Thread user2 = new Thread(() -> {
            CoffeeRecipe latte = machine.selectCoffee("Latte");
            machine.dispenseCoffee(latte, new Payment(4.0));
        });

        user1.start();
        user2.start();
    }
}