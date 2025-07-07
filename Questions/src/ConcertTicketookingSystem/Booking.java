package ConcertTicketookingSystem;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Booking {
    private final String id;
    private final User user;
    private final Concert concert;
    private final List<Seat> seats;
    private final Instant bookedAt;
    private final double totalAmount;

    public Booking(User user, Concert concert, List<Seat> seats, double totalAmount) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.bookedAt = Instant.now();
        this.totalAmount = totalAmount;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Concert getConcert() { return concert; }
    public List<Seat> getSeats() { return seats; }
    public double getTotalAmount() { return totalAmount; }
}