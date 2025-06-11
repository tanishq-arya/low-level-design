package AdapterPattern.Example;

public interface NotificationService {
    void send(String to, String subject, String body);
}