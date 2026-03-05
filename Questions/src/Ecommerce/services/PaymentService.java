package Ecommerce.services;

import Ecommerce.models.Order;

public class PaymentService {
    PaymentStrategy strategy;

    boolean processPayment(Order order) {
        return strategy.pay(order.getOrderAmount());
    }
}
