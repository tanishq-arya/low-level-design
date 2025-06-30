package OnlineAuctionSystem;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AuthService {
    private final Map<String, User> usersByEmail = new ConcurrentHashMap<>();
    private final Map<String, String> tokensToUserId = new ConcurrentHashMap<>();

    // Register a new user
    public User register(String name, String email, String passwordHash) {
        User user = new User(name, email, passwordHash);
        usersByEmail.put(user.getEmail(), user);
        return user;
    }

    // Log in and get a session token
    public String login(String email, String passwordHash) {
        User user = usersByEmail.get(email);
        if (user.getEmail().equals(email) && user.getPasswordHash().equals(passwordHash)) {
            String token = UUID.randomUUID().toString();
            tokensToUserId.put(token, user.getEmail());
            System.out.println("Logged in user: " + email + ", token: " + token);
            return token;
        }

        System.out.println("Invalid credentials");
        return "null";
    }

    // Fetch the user for a given token
    public User getUserByToken(String token) {
        String userEmail = tokensToUserId.get(token);
        if (userEmail == null) {
            System.out.println("Invalid or expired token");
            return null;
        }
        return usersByEmail.get(userEmail);
    }
}