package Ecommerce.models;

import RestaurantManagementSystem.Order;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;

    // relationships
    private Cart cart;
    private List<Order> orders;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
