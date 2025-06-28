package PubSubSystem;

public class TopicSubscriber implements Subscriber{
    private final String name;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onMessage(String topic, Message msg) {
        System.out.println(name + " received msg: " + msg.getContent() + " from topic: " + topic);
    }
}