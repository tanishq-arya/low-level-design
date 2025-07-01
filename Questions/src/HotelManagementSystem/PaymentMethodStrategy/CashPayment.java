package HotelManagementSystem.PaymentMethodStrategy;

public class CashPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing cash payment of $" + amount);
        return true;
    }
}