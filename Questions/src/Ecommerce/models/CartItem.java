package Ecommerce.models;

public class CartItem {
    Long cartId;
    Long productId;
    Integer qty;


    // relationships
    Cart cart;
    Product product;

    public CartItem(Long cartId, Product product, int qty) {
        this.cartId = cartId;
        this.product = product;
        this.qty = qty;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQty() {
        return qty;
    }
}
