package RestaurantManagementSystem;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final Customer customer;
    private final List<MenuItem> items;
    private OrderStatus status;
    private double totalAmount;

    public Order(Customer customer, List<MenuItem> items) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = items;
        this.status = OrderStatus.PLACED;
        calculateTotal();
    }

    private void calculateTotal() {
        this.totalAmount = items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public void markPreparing() { this.status = OrderStatus.PREPARING; }
    public void markServed()    { this.status = OrderStatus.SERVED;    }
    public void markCompleted() { this.status = OrderStatus.COMPLETED; }
    public void cancel()        { this.status = OrderStatus.CANCELLED; }

    public String getId() {return this.id;}
    public Customer getCustomer() {return this.customer;}
    public double getTotalAmount() {return totalAmount;}
    public OrderStatus getStatus() {return this.status;}
    public List<MenuItem> getItems() {return this.items;}
}