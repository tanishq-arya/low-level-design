package Ecommerce.models;


import java.util.List;
import java.util.UUID;

public class Cart {
    Long id;
    Long userId;
    Status status; // PENDING, SUCCESS, FAILED

    public Cart(long userId) {
        this.userId = userId;
    }

    // relationships
    private User user;
    private List<CartItem> items;

    public void addItem(Product product, int qty) {
        items.add(new CartItem(id, product, qty));
    }

    public List<CartItem> getItems() {
        return items;
    }
}
