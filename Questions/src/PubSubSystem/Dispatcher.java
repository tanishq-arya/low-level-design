package PubSubSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Dispatches messages to subscribers asynchronously
public class Dispatcher {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    // Using executor service to run in background asynchronously
    public void dispatch(Topic topic, Message msg) {
        for (Subscriber sub : topic.getSubscribers()) {
            executor.submit(() -> {
                sub.onMessage(topic.getName(), msg);
            });
        }
    }

    // We can simply also call a function
    public void dispatchNormally(Topic topic, Message msg) {
        for (Subscriber sub : topic.getSubscribers()) {
            sub.onMessage(topic.getName(), msg);
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}