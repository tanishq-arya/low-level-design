// Concrete decorator class that adds Whipped Cream to a Coffee object, enhancing its description and adjusting its cost.

package DecoratorPattern.Exercise;

public class WhippedCream extends CoffeeDecorator {

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.70; 
    }
}