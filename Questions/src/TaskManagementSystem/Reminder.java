package TaskManagementSystem;

import java.util.Date;
import java.util.UUID;

public class Reminder {
    private final String id;
    private final Date remindAt;
    private boolean sent;

    public Reminder(Date remindAt) {
        this.id = UUID.randomUUID().toString();
        this.remindAt = remindAt;
        this.sent = false;
    }

    public Date getRemindAt() {
        return remindAt;
    }

    public boolean isSent() {
        return sent;
    }

    public void markSent() {
        this.sent = true;
    }
}