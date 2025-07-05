package RestaurantManagementSystem;

import java.util.UUID;

public class Payment {
    private final String id;
    private final Order order;
    private final double amount;
    private final String method; // CASH, CARD, MOBILE > can be converted strategy
    private PaymentStatus status;

    public Payment(Order order, double amount, String method) {
        this.id = UUID.randomUUID().toString();
        this.order = order;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
    }

    public void process() {
        // simulate
        System.out.println("Paying " + amount + " via " + method + " ...");
        System.out.println("Payment done");
        this.status = PaymentStatus.PAID;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}