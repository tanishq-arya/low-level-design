package CarRentalSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentProcessor {
    private final Map<String, Payment> payments = new ConcurrentHashMap<>();

    /// Process and store payment; returns the Payment record
    public synchronized Payment processPayment(Reservation reservation, double amount) {
        if (amount < reservation.getTotalCost()) {
            throw new RuntimeException("Insufficient amount");
        }
        Payment payment = new Payment(reservation, amount);
        payment.setStatus(PaymentStatus.PAID);
        payments.put(payment.getId(), payment);
        return payment;
    }

    public Payment getPayment(String paymentId) {
        Payment payment = payments.get(paymentId);
        if (payment == null) throw new RuntimeException("Payment not found");
        return payment;
    }

    /** Issue refund (penalty logic can be applied) */
    public synchronized void refund(String paymentId) {
        Payment payment = getPayment(paymentId);
        payment.setStatus(PaymentStatus.REFUNDED);
    }
}