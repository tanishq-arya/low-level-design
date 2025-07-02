package DigitalWalletService;

public class DummyPaymentMethod implements PaymentMethod {
    @Override
    public boolean charge(double amount) {
        System.out.println("Charging via dummy PM: ₹" + amount);
        return true;
    }

    @Override
    public boolean refund(double amount) {
        System.out.println("Refund via dummy PM: ₹" + amount);
        return true;
    }
}