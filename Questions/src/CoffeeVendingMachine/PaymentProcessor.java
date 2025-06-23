package CoffeeVendingMachine;

public class PaymentProcessor {
    // process payment and return change
    public double process(double price, double paid) {
        if (paid < price) {
            throw new IllegalArgumentException(
                    "Insufficient payment. Paid: " + paid  + ", required: " + price
            );
        }
        return paid - price;
    }
}