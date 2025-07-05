package RestaurantManagementSystem;

import RestaurantManagementSystem.Managers.InventoryManager;
import RestaurantManagementSystem.Managers.OrderManager;

import java.util.List;

public interface OrderingStrategy {
    Order placeOrder(Customer customer, List<MenuItem> items, OrderManager orderManager, InventoryManager inventoryManager);
}