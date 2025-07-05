package RestaurantManagementSystem.Managers;

import RestaurantManagementSystem.Customer;
import RestaurantManagementSystem.MenuItem;
import RestaurantManagementSystem.Order;
import RestaurantManagementSystem.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderManager {
    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    public synchronized Order create(Customer customer, List<MenuItem> items) {
        Order order = new Order(customer, items);
        System.out.println("Order placed: " + order.getId()
                + ", Total = ₹" + order.getTotalAmount());
        orders.put(order.getId(), order);
        return order;
    }

    public synchronized void updateStatus(String orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if (order != null) {
            switch (status) {
                case PREPARING -> order.markPreparing();
                case SERVED -> order.markServed();
                case COMPLETED -> order.markCompleted();
                case CANCELLED -> order.cancel();
            }
        }
    }

    public List<Order> listByCustomer(String customerId) {
        List<Order> list = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getCustomer().getId().equals(customerId)) {
                list.add(order);
            }
        }
        return list;
    }

    public Order getOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new RuntimeException("No order found: " + orderId);
        }

        return order;
    }

    public List<Order> getAllOrders() {
        return orders.values().stream().toList();
    }
}