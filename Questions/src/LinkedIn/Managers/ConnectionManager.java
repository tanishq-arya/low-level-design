package LinkedIn.Managers;

import LinkedIn.ConnectionRequest;
import LinkedIn.Notification;
import LinkedIn.Services.NotificationService;
import LinkedIn.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionManager {
    private final Map<String, ConnectionRequest> requests = new ConcurrentHashMap<>();
    public ConnectionRequest sendRequest(User from, User to) {
        ConnectionRequest req = new ConnectionRequest(from, to);
        requests.put(req.getId(), req);
        NotificationService.getInstance().notify(
            new Notification(to, Notification.Type.CONNECTION_REQUEST, from.getName())
        );
        return req;
    }
    public void respond(String reqId, ConnectionRequest.Status status) {
        ConnectionRequest req = requests.get(reqId);
        req.setStatus(status);
        // notification logic...
    }
}