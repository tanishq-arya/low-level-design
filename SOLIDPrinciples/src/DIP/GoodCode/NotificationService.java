package DIP.GoodCode;

public class NotificationService {
    private final NotificationChannel notificationChannel;

    public NotificationService(NotificationChannel channel) {
        this.notificationChannel = channel;
    }

    void notify(String msg) {
        notificationChannel.send(msg);
    }
}
