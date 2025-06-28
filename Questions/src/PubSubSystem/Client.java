package PubSubSystem;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        PubSubService service = new PubSubService();

        // Create subscribers
        Subscriber alice = new TopicSubscriber("Alice");
        Subscriber bob = new TopicSubscriber("Bob");

        // Subscribe to topics
        service.subscribe("Sports", alice);
        service.subscribe("News", alice);
        service.subscribe("News", bob);

        // Publish messages
        service.publish("Sports", new Message("RCB won the IPL trophy."));
        service.publish("News", new Message("Heavy rainfall in Noida."));
        service.publish("News", new Message("Weather forecast: alert for more rain."));


        // Allow async dispatch to complete
        Thread.sleep(500);

        // Unsubscribe
        service.unsubscribe("News", alice);

        // Publish more
        service.publish("News", new Message("Stock markets up by 5%."));

        Thread.sleep(500);
        service.shutdown();
    }
}