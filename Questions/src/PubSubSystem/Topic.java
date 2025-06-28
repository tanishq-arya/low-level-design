package PubSubSystem;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
    // maintain a list of subs
    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }
}