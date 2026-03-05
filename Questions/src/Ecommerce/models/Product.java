package Ecommerce.models;

public class Product {
    // skipping private final
    Long id;
    String name;
    String description;
    Double price;
    String category;

    // relationship
    private Inventory inventory;

    public Long getId() {
        return id;
    }
}
