package Ecommerce.models;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    Long id;
    Status status;
    Double amount;
    LocalDateTime created_at;

    // relationship
    Long userId; // FK
    List<OrderItem> items;
    Payment payment;

    public double getOrderAmount() {
        double amt = 0;
        for (OrderItem item: items) {
            amt += item.getTotalPrice();
        }
        return amt;
    }
}
