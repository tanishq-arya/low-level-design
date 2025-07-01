package HotelManagementSystem.Services;

import HotelManagementSystem.Payment;
import HotelManagementSystem.PaymentMethodStrategy.PaymentMethod;
import HotelManagementSystem.PaymentStatus;
import HotelManagementSystem.Reservation;

import java.time.temporal.ChronoUnit;

// Calculates bill amounts and collects payment via payment method
public class BillingService {
    // Calculates total for a reservation: nights × rate
    private double generateBill(Reservation reservation) {
        long nights = ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
        return nights * reservation.getRoom().getRatePerNight();
    }

    // Process payment for a reservation
    public synchronized Payment collectPayment(Reservation reservation, PaymentMethod method) {
        double amount = generateBill(reservation);
        boolean ok = method.pay(amount); // process payment

        // update status
        Payment payment = new Payment(reservation, amount);
        payment.setStatus(ok ? PaymentStatus.PAID : PaymentStatus.FAILED);

        return payment;
    }
}