package LinkedIn;

import java.util.UUID;

public class Message {
    private final String id;
    private final User fromUser;
    private final User toUser;
    private final String content;
    private final long sentAt;

    public Message(User fromUser, User toUser, String content) {
        this.id = UUID.randomUUID().toString();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sentAt = System.currentTimeMillis();
    }

    public User getTo() {
        return toUser;
    }

    public String getContent() {
        return content;
    }

    public User getFrom() {
        return fromUser;
    }
}