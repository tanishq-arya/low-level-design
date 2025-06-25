package LinkedIn;

import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String email;
    private String passwordHash;

    // Extension > set and update user profile
    // Profile profile;

    public User(String name, String email, String passwordHash) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}