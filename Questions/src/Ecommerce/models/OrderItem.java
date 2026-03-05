package Ecommerce.models;

public class OrderItem {
    Long orderId;
    Long productId;
    Integer qty;
    Double price;

    public double getTotalPrice() {
        return price * qty;
    }
}
