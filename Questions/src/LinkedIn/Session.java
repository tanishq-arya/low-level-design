package LinkedIn;

import java.util.UUID;

public class Session {
    private final String token;
    private final User user;
    private final long createdAt;

    public Session(User user) {
        this.token = UUID.randomUUID().toString();
        this.user = user;
        this.createdAt = System.currentTimeMillis();
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }
}