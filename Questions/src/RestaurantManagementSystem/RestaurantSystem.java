package RestaurantManagementSystem;

import RestaurantManagementSystem.Managers.InventoryManager;
import RestaurantManagementSystem.Managers.OrderManager;
import RestaurantManagementSystem.Managers.ReservationManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantSystem {
    private final ReservationManager reservationManager = new ReservationManager();
    private final OrderManager orderManager = new OrderManager();
    private final InventoryManager inventoryManager = new InventoryManager();

    private final List<MenuItem> menu = new ArrayList<>();

    public RestaurantSystem() {
    }

    public List<MenuItem> viewMenu() {
        // pre-loaded menu
        return menu;
    }

    public Reservation makeReservation(Customer customer, LocalDateTime dt, int size) {
        return reservationManager.create(customer, dt, size);
    }

    public Order placeOrder(Customer customer, List<MenuItem> items, OrderingStrategy strat) {
        return strat.placeOrder(customer, items, orderManager, inventoryManager);
    }

    public Payment processPayment(String orderId, String method) {
        Order order = orderManager.getOrder(orderId);
        orderManager.listByCustomer(order.getCustomer().getId())
                .stream().filter(x->x.getId().equals(orderId)).findFirst().get();
        Payment p = new Payment(order, order.getTotalAmount(), method);
        p.process();
        order.markCompleted();
        return p;
    }

    public Report generateSalesReport() {
        return new SalesReport(orderManager).generate();
    }

    public void addIngredient(Ingredient ingredient) {
        inventoryManager.addIngredient(ingredient);
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }
}