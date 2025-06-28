package PubSubSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Facade
public class PubSubService {
    private final Map<String, Topic> topicMap = new ConcurrentHashMap<>();
    private final Dispatcher dispatcher = new Dispatcher();

    // Publish Message to topic (create topic if not present)
    public void publish(String topicName, Message msg) {
        Topic topic = topicMap.computeIfAbsent(topicName, Topic::new);
        dispatcher.dispatchNormally(topic, msg);
//        dispatcher.dispatch(topic, msg); // Using executor service
    }

    // Subscribe to a topic
    public void subscribe(String topicName, Subscriber sub) {
        Topic topic = topicMap.computeIfAbsent(topicName, Topic::new); // create new topic if not present
        topic.addSubscriber(sub);
    }

    // Unsubscribe from a topic
    public void unsubscribe(String topicName, Subscriber sub) {
        Topic topic = topicMap.get(topicName);
        if (topic == null) {
            System.out.println("Topic not found !!");
        } else {
            topic.removeSubscriber(sub);
        }
    }

    // cleanup resources
    public void shutdown() {
        dispatcher.shutdown();
    }
}