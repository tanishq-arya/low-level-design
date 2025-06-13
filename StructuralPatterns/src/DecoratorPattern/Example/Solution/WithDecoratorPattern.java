package DecoratorPattern.Example.Solution;

public class WithDecoratorPattern {
    public static void main(String[] args) {
        // Basic Pizza

        Pizza pizza = new BasicPizza();

        // Add Cheese
        pizza = new CheeseDecorator(pizza);

        // Add mushroom
        pizza = new MushroomDecorator(pizza);

        // Add Olives
        pizza = new OliveDecorator(pizza);

        System.out.println("Order: " + pizza.getDescription());
        System.out.println("Final Cost: $" + pizza.getCost());
    }
}