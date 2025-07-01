package HotelManagementSystem;

import HotelManagementSystem.PaymentMethodStrategy.CreditCardPayment;

import java.time.LocalDate;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        HotelService hotel = new HotelService();

        // Setup rooms
        hotel.registerRoom(new Room("101", RoomType.SINGLE, 2000));
        hotel.registerRoom(new Room("102", RoomType.DOUBLE, 3000));
        hotel.registerRoom(new Room("201", RoomType.DELUXE, 5000));
        hotel.registerRoom(new Room("301", RoomType.SUITE, 8000));

        // Create guest
        Guest alice = new Guest("Alice", "alice@example.com", "ID123");

        // Create guest
        Guest bob = new Guest("Bob", "bob@example.com", "ID123");

        // Book room
        LocalDate today = LocalDate.now();
        Reservation reservation = hotel.bookRoom(alice, RoomType.DELUXE, today, today.plusDays(2));
        System.out.println("Booked reservation: " + reservation.getId());

        Reservation reservationBob = hotel.bookRoom(bob, RoomType.DELUXE, today, today.plusDays(2));
        System.out.println("Booked reservation: " + reservationBob);

        // Check-in
        hotel.checkIn(reservation.getId());
        System.out.println("Checked in: " + reservation.getGuest().getName() + " ," + reservation.getId());

        // Pay
        Payment payment = hotel.pay(reservation.getId(), new CreditCardPayment("1111-2222"));
        System.out.println("Payment status: " + payment.getStatus());

        // Report
        Map<RoomType, Double> occupancyRate = hotel.reportOccupancy();
        System.out.println("Occupancy rates: " + occupancyRate);

        // Check-out
        hotel.checkOut(reservation.getId());
        System.out.println("Checked out: " + reservation.getId());
    }
}