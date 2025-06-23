package CoffeeVendingMachine;

// Kind of Receipt
public class Payment {
    private final double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}