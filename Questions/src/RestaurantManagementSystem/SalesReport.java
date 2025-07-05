package RestaurantManagementSystem;

import RestaurantManagementSystem.Managers.OrderManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesReport implements ReportGenerator {
    private final OrderManager orderManager;

    public SalesReport(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Override
    public Report generate() {
        // Gather all completed orders
        List<Order> orders = orderManager.getAllOrders().stream()
                .filter(o -> o.getStatus() == OrderStatus.COMPLETED)
                .toList();

        double totalRevenue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();

        Map<String, Long> itemCounts = orders.stream()
                .flatMap(o -> o.getItems().stream())
                .collect(Collectors.groupingBy(MenuItem::getName, Collectors.counting()));

        StringBuilder sb = new StringBuilder()
                .append("Total Revenue: ₹").append(totalRevenue).append("\n\n")
                .append("Items Sold:\n");
        itemCounts.forEach((item, count) ->
                sb.append("  ").append(item)
                        .append(": ").append(count).append("\n")
        );

        return new Report("Sales Summary", sb.toString());
    }
}