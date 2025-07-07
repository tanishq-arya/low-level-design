package ConcertTicketookingSystem;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Hold {
    private final String id;
    private final User user;
    private final Concert concert;
    private final List<Seat> seats;
    private final Instant createdAt;
    private final long expiresInSeconds; // hold for 120s

    public Hold(User user, Concert concert, List<Seat> seats, long expiresInSeconds) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.concert = concert;
        this.seats = seats;
        this.createdAt = Instant.now();
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Concert getConcert() { return concert; }
    public List<Seat> getSeats() { return seats; }

    // Check if hold has expired
    public boolean isExpired() {
        return Instant.now().isAfter(createdAt.plusSeconds(expiresInSeconds));
    }
}