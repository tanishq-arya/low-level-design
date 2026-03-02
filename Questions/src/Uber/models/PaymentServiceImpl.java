package Uber.models;

import java.util.concurrent.ConcurrentHashMap;

interface PaymentService {
    Payment processPayment(String tripId, double amount, String method);

    // refunds - maybe later
    // void refund(String paymentId);
}

public class PaymentServiceImpl implements PaymentService {
    // local data store
    private final ConcurrentHashMap<String, Payment> paymentStore = new ConcurrentHashMap<>();

    @Override
    public Payment processPayment(String tripId, double amount, String method) {

        return null;
    }
}