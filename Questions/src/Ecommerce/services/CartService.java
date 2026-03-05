package Ecommerce.services;

import Ecommerce.models.Cart;
import Ecommerce.models.Product;

import java.util.HashMap;
import java.util.Map;

// main focus - handling of cart
public class CartService {
    Map<Long, Cart> cartStore = new HashMap<>();
    ProductRepository productRepo = new ProductRepository();

    Cart getCart(Long id) {
        return null;
    }

    void addItem(Long userId, Long productId, int qty) {
        Cart cart = cartStore.computeIfAbsent(userId, Cart::new);

        Product product = productRepo.getProduct(productId);

        cart.addItem(product, qty);
    }

    void removeItem(Long userId, Long productId) {

    }

    void updateQty(Long userId, Long productId, int qty) {

    }

    void clearCart(Long userId) {

    }
}
