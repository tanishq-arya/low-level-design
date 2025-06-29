package CarRentalSystem;

import java.time.LocalDate;
import java.util.UUID;

public class Payment {
    private final String id;
    private final Reservation reservation;
    private final double amount;
    private final LocalDate paymentDate;
    private PaymentStatus status;

    public Payment(Reservation reservation, double amount) {
        this.id = UUID.randomUUID().toString();
        this.reservation = reservation;
        this.amount = amount;
        this.paymentDate = LocalDate.now();
        this.status = PaymentStatus.PENDING;
    }

    public String getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public double getAmount() { return amount; }
    public LocalDate getPaymentDate() { return paymentDate; }
    public synchronized PaymentStatus getStatus() { return status; }
    public synchronized void setStatus(PaymentStatus status) { this.status = status; }
}