package PubSubSystem;

import java.util.Date;

public class Message {
    private final String content;
    private final Date timestamp;

    public Message(String content) {
        this.content = content;
        this.timestamp = new Date();
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}