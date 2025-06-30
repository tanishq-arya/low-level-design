package OnlineAuctionSystem;

import java.time.Instant;
import java.util.UUID;

public class Notification {
    private final String id;
    private final String message;
    private final Instant timestamp;

    private NotificationStatus status;

    public Notification(String message) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.timestamp = Instant.now();
        status = NotificationStatus.UNREAD;
    }

    public void markRead() {
        this.status = NotificationStatus.READ;
    }

    // getters
    public String getId() { return id; }
    public String getMessage() { return message; }
    public Instant getTimestamp() { return timestamp; }
    public NotificationStatus getStatus() { return status; }
}