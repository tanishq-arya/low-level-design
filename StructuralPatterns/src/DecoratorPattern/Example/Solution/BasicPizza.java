package DecoratorPattern.Example.Solution;

public class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getCost() {
        return 100;
    }
}