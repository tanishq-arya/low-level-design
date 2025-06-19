package VendingMachine.State;

public class DispenseState implements State {
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Coin coin) {
        // Edge case > If user inserts extra coins in dispense state
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin);

        System.out.println("Product already selected and Payment done. Please collect the dispensed product.");
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
        vendingMachine.setState(vendingMachine.getReturnChangeState()); // move to next state
    }

    @Override
    public void returnChange() {
        System.out.println("Product already selected. Please collect the dispensed product.");
    }
}