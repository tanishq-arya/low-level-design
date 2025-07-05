package RestaurantManagementSystem;

import RestaurantManagementSystem.Managers.InventoryManager;
import RestaurantManagementSystem.Managers.OrderManager;

import java.util.List;

public class DineInOrder implements OrderingStrategy {
    @Override
    public Order placeOrder(Customer customer, List<MenuItem> items, OrderManager orderManager, InventoryManager inventoryManager) {
        if (!inventoryManager.checkAvailability(items)) {
            throw new RuntimeException("Items out of stock");
        }
        inventoryManager.deductForOrder(items);
        return orderManager.create(customer, items);
    }
}