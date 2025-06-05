package MediatorPattern.Example;

// Chat system
class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String msg, User recipient) {
        System.out.println(this.name + " sending " + msg + " to " + recipient.getName());
    }

    public String getName() {
        return name;
    }
}

public class WithoutMediatorPattern {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        alice.sendMessage("hi", bob);
        alice.sendMessage("hello", charlie);
    }
}