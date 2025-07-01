package HotelManagementSystem.PaymentMethodStrategy;

public class CreditCardPayment implements PaymentMethod {
    private final String cardNumber;
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount
                + " using card " + cardNumber);
        return true; // assume success
    }
}