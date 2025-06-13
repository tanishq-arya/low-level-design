// Concrete decorator class that adds Sugar to a Coffee object, enhancing its description and adjusting its cost.

package DecoratorPattern.Exercise;

public class Sugar extends CoffeeDecorator {

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.30; 
    }
}