package Ecommerce.models;

public class Payment {
    Long id;
    Long orderId;
    Double amount;
    Status status;
    String paymentMethod; // CARD, UPI, WALLET

    // relationship
    private Order order;
}
