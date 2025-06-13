package DecoratorPattern.Example.Problem;

public class CheeseOlivePizza extends CheesePizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 25.0;
    }
}