package Ecommerce.services;

public interface PaymentStrategy {
    boolean pay (double amount);
}


class UPIPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing upi payment");
        return true;
    }
}
