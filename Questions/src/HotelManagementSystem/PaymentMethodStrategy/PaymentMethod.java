package HotelManagementSystem.PaymentMethodStrategy;

// Strategy interface for payment methods.
public interface PaymentMethod {
    // process payment
    boolean pay(double amount);
}