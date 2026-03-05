package Ecommerce.models;

public class Inventory {
    Long productId;
    Integer availableQty;
    public Integer reservedQty;

    // relationship - ?
    Product product;

    public int getRemainingStock() {
        return availableQty - reservedQty;
    }
}
