package RestaurantManagementSystem;

public class Ingredient {
    private final String id;
    private final String name;
    private int quantityInStock; // (grams, pieces, etc.)
    private final String unit;

    public Ingredient(String id, String name, int initialQuantity, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.quantityInStock = initialQuantity;
    }

    public synchronized boolean deduct(int qty) {
        if (quantityInStock < qty) return false;
        quantityInStock -= qty;
        return true;
    }

    public synchronized void replenish(int qty) {
        quantityInStock += qty;
    }

    public String getId() {return id;}
    public String getName() {return name;}
    public int getQuantityInStock() {return quantityInStock;}
    public String getUnit() {return this.unit;}
}