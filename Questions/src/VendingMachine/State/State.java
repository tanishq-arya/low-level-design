package VendingMachine.State;

public interface State {
    void insertCoin(Coin coin);
    void selectProduct(Product product);
    void cancel();
    void dispense();
    void returnChange();
}