// Concrete decorator class that adds Milk to a Coffee object, modifying its description and cost accordingly.

package DecoratorPattern.Exercise;

public class Milk extends CoffeeDecorator {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.50; 
    }
}