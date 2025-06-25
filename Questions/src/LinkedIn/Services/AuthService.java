package LinkedIn.Services;

import LinkedIn.Session;
import LinkedIn.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Singleton
public class AuthService {
    // static instance > whole app
    private static AuthService instance;

    // resources
    private final Map<String, User> users = new ConcurrentHashMap<>(); // email -> user
    private final Map<String, Session> sessions = new ConcurrentHashMap<>(); // email -> session
     private final PasswordHasher hasher = new PasswordHasherImpl();

    private AuthService() {}
    public static synchronized AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public User register(String name, String email, String password) {
        if (users.containsKey(email)) {
            System.out.println("Email already registered");
            throw new RuntimeException("Email already registered.");
        }

        String hash = hasher.hash(password); // ** Imp.

        User user = new User(name, email, hash); // create object
        users.put(user.getEmail(), user);  // add to map
        return user;
    }

    public String login(String email, String password) {
        User user = users.get(email);
        // login user if password matches
        if (user == null || !hasher.matches(password, user.getPasswordHash())) {
            System.out.println("Invalid credentials.");
            throw new RuntimeException("Invalid credentials");
        }
        Session session = new Session(user);
        sessions.put(session.getToken(), session);
        return session.getToken();
    }

    public void logout(String token) {
        System.out.println("Logged out: " + sessions.get(token).getUser().getName());
        sessions.remove(token);
    }

    public User authenticate(String token) {
        Session session = sessions.get(token);
        if (session == null) throw new RuntimeException("Invalid session token");
        return session.getUser();
    }
}