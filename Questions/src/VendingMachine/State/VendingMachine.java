package VendingMachine.State;

public class VendingMachine {
    private static VendingMachine instance;
    Inventory inventory;
    private final State idleState;
    private final State readyState;
    private final State dispenseState;
    private final State returnChangeState;
    private State currentState;
    private Product selectedProduct;
    private double totalPayment;

    // State Diagram
    // Idle > Ready [input coins] > Dispense [dispense product] > ReturnChange [return change]

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
        selectedProduct = null;
        totalPayment = 0.0;
    }

    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public Product addProduct(String name, int price, int quantity) {
        Product product = new Product(1, name, price);
        inventory.addProduct(product, quantity);
        return product;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void dispenseProduct() {
        currentState.dispense();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    void setState(State state) {
        currentState = state;
    }

    Inventory getInventory() {
        return inventory;
    }

    State getIdleState() {
        return idleState;
    }

    State getReadyState() {
        return readyState;
    }

    State getDispenseState() {
        return dispenseState;
    }

    State getReturnChangeState() {
        return returnChangeState;
    }

    Product getSelectedProduct() {
        return selectedProduct;
    }

    void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    void resetSelectedProduct() {
        selectedProduct = null;
    }

    double getTotalPayment() {
        return totalPayment;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void resetPayment() {
        totalPayment = 0.0;
    }
}