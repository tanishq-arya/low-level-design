package Ecommerce.services;

import Ecommerce.models.Cart;
import Ecommerce.models.CartItem;
import Ecommerce.models.Order;

public class OrderService {
    CartService cartService; // singleton pattern
    InventoryService inventoryService;

    Order checkout(Long userId) throws Exception {
        Cart cart = cartService.getCart(userId);

        for(CartItem item: cart.getItems()) { // reserve each item
            boolean success = inventoryService.reserveInventory(item.getProductId(), item.getQty());

            if(!success) {
                throw new Exception("Out of Stock");
            }
        }

        // OrderRepo > handle orders
        return createOrder(cart);
    }

    private Order createOrder(Cart cart) {
        return null;
    }

}
