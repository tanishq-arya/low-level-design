package DecoratorPattern.Example.Solution;

public class OliveDecorator extends PizzaDecorator{
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Olive";
    }

    @Override
    public double getCost() {
        return super.getCost() + 150;
    }
}