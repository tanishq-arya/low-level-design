package ConcertTicketookingSystem;

import java.time.Instant;
import java.util.UUID;

public class WaitlistEntry {
    private final String id;
    private final User user;
    private final Concert concert;
    private final Instant requestedAt;

    public WaitlistEntry(User user, Concert concert) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.concert = concert;
        this.requestedAt = Instant.now();
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Concert getConcert() { return concert; }
}