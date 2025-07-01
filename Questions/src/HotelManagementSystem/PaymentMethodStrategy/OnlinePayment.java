package HotelManagementSystem.PaymentMethodStrategy;

public class OnlinePayment implements PaymentMethod {
    private final String accountId;
    public OnlinePayment(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing online payment of $" + amount
                + " from account " + accountId);
        return true; // assume success
    }
}