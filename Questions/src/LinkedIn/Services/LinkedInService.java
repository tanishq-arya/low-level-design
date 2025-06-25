package LinkedIn.Services;

import LinkedIn.*;
import LinkedIn.Managers.ConnectionManager;
import LinkedIn.Managers.JobManager;
import LinkedIn.Managers.UserManager;

import java.util.List;

public class LinkedInService {
    private static LinkedInService instance;

    private final AuthService auth = AuthService.getInstance();
    private final MessagingService msgSvc = new MessagingService();

    private final UserManager userMgr = new UserManager();
    private final ConnectionManager connMgr = new ConnectionManager();
    private final JobManager jobMgr   = new JobManager();

    LinkedInService() {}

    public static LinkedInService getInstance() {
        if (instance == null) {
            instance = new LinkedInService();
        }
        return instance;
    }

    public User register(String name, String email, String pwd) {
        User user = auth.register(name, email, pwd);
        userMgr.addUser(user);
        System.out.println("User registered: " + name);
        return user;
    }

    public String login(String email, String pwd) {
        return auth.login(email,pwd);
    }

    public void sendConnectionRequest(String token, String toUserId) {
        User from = auth.authenticate(token);
        User to   = userMgr.getUser(toUserId);
        connMgr.sendRequest(from, to);
    }

    public JobPost postJob(String token, String title, String desc, User company) {
        auth.authenticate(token);
        return jobMgr.postJob(new JobPost(title,desc,company));
    }

    public void sendMessage(String token, String toUserId, String content) {
        User from = auth.authenticate(token);
        User to   = userMgr.getUser(toUserId);
        msgSvc.sendMessage(new Message(from,to,content));
    }

    public void registerNotificationListener(NotificationListener listener) {
        NotificationService.getInstance().addListener(listener);
    }

    public void createProfile(String token, String name, String description, List<String> skills) {
        System.out.println("Profile created");
        // User user = auth.authenticate(token);
        // user.setProfile();
    }

    public List<Notification> getNotifications(String token) {
        System.out.println("Notifications");
        return List.of();
    }

    public void logout(String token) {
        auth.logout(token);
    }

    public List<Message> fetchConversation(String aliceToken, String id) {
        return List.of();
    }
}