package LinkedIn;

import java.util.UUID;

public class Notification {
    public enum Type { CONNECTION_REQUEST, JOB_POST, MESSAGE }
    private final String id;
    private final User recipient;
    private final Type type;
    private final String payload;
    private final long createdAt;
    private boolean read;

    public Notification(User recipient, Type type, String payload) {
        this.id = UUID.randomUUID().toString();
        this.recipient = recipient;
        this.type = type;
        this.payload = payload;
        this.createdAt = System.currentTimeMillis();
        this.read = false;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }
}