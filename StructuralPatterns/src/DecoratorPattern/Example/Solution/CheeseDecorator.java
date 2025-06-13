package DecoratorPattern.Example.Solution;

public class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 100;
    }
}