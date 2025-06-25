package LinkedIn;

import java.util.Date;
import java.util.UUID;

public class ConnectionRequest {
    public enum Status {PENDING, ACCEPTED, REJECTED}
    private final String id;
    private final User fromUser;
    private final User toUser;
    private Status status;
    private final long timestamp;

    public ConnectionRequest(User fromUser, User toUser) {
        this.id = UUID.randomUUID().toString();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.status = Status.PENDING;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}