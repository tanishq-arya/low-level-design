package VendingMachine.State;

public class Product {
    private final int id;
    private final String name;
    private final double price; // in rupees

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}