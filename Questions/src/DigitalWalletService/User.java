package DigitalWalletService;

import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String passwordHash;


    public User(String name, String email, String passwordHash) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getId()     { return id; }
    public String getName()   { return name; }
    public String getEmail()  { return email; }
    // passwordHash would be used internally for auth
}