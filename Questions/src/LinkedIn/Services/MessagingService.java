package LinkedIn.Services;

import LinkedIn.Message;
import LinkedIn.Notification;
import LinkedIn.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessagingService {
    private final List<Message> messages = new CopyOnWriteArrayList<>();
    public void sendMessage(Message msg) {
        messages.add(msg);
        NotificationService.getInstance().notify(
            new Notification(msg.getTo(), Notification.Type.MESSAGE, msg.getContent())
        );
    }

    public List<Message> fetchConversation(User u1, User u2) {
        return messages.stream()
                .filter(m -> (m.getFrom() == u1 && m.getTo() == u2) || (m.getFrom() == u2 && m.getTo() == u1))
                .toList();
    }
}