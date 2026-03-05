package Ecommerce.services;

import Ecommerce.models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    Map<Long, Product> products = new HashMap<>();

    Product getProduct(Long id) {
        return products.get(id);
    }

    void save(Product product) {
        products.put(product.getId(), product);
    }
}
