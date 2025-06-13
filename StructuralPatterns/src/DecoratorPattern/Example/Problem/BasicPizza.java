package DecoratorPattern.Example.Problem;

public class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 100;
    }
}