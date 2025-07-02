package DigitalWalletService;

// Strategy interface for payment methods
public interface PaymentMethod {
    boolean charge(double amount);

    boolean refund(double amount);
}