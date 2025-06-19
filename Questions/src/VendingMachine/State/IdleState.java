package VendingMachine.State;

public class IdleState implements State {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.getInventory().isAvailable(product)) {
            System.out.println("Product selected: " + product.getName());
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState()); // move to next state
        } else {
            System.out.println("Product not available: " + product.getName());
        }
    }

    @Override
    public void cancel() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void returnChange() {
        System.out.println("Please select a product first.");
    }
}