package PubSubSystem;

// Subscriber interface: subscriber receives messages
public interface Subscriber {
    void onMessage(String topic, Message msg);
}