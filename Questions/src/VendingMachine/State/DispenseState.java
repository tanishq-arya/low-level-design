package VendingMachine.State;

public class DispenseState implements State {
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void cancel() {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }

    @Override
    public void dispense() {
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.getInventory().removeProduct(product);
        System.out.println("Product dispensed: " + product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }
}