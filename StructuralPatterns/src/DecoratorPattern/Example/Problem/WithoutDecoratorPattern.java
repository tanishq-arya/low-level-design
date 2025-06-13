package DecoratorPattern.Example.Problem;

public class WithoutDecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new CheeseOlivePizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

        // Problems:
        // 1. Scalability
        // 2. Maintainability [Class explosion]
    }
}