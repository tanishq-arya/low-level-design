package LinkedIn.Services;

import LinkedIn.Notification;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Singleton
public class NotificationService {
    private static NotificationService instance;

    private final List<NotificationListener> listeners = new CopyOnWriteArrayList<>();

    private NotificationService() {}
    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void addListener(NotificationListener l) {
        listeners.add(l);
    }

    public void notify(Notification notification) {
        listeners.forEach(l -> l.onNotification(notification));
    }
}