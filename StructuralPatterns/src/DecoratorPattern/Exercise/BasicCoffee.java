// This class represents implementation of the Coffee interface representing a basic coffee with a fixed description and cost.

package DecoratorPattern.Exercise;

public class BasicCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 3.00; 
    }
}