package LinkedIn.Managers;

import LinkedIn.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    public void addUser(User user) { users.put(user.getId(), user); }
    public User getUser(String id) { return users.get(id); }
}