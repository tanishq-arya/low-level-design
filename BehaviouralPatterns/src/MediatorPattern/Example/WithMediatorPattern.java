package MediatorPattern.Example;

import java.util.ArrayList;
import java.util.List;

// Chat system

interface ChatMediator {
    void sendMessage(String msg, ChatUser user);

    void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator {
    private final List<ChatUser> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, ChatUser sender) {
        for (ChatUser user : this.users) {
            if (!user.equals(sender)) {
                user.receiveMessage(msg, sender);
            }
        }
    }

    @Override
    public void addUser(ChatUser user) {
        users.add(user);
    }
}

class ChatUser {
    private final String name;
    private final ChatMediator chatMediator;

    public ChatUser(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public void sendMessage(String msg) {
        System.out.println(this.name + " sending a msg: " + msg);
        chatMediator.sendMessage(msg, this);
    }

    public void receiveMessage(String msg, ChatUser sender) {
        System.out.println(this.name + " received " + msg + " from " + sender.getName());
    }

    public String getName() {
        return name;
    }
}

public class WithMediatorPattern {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        ChatUser alice = new ChatUser("Alice", chatRoom);
        ChatUser bob = new ChatUser("Bob", chatRoom);
        ChatUser charlie = new ChatUser("Charlie", chatRoom);

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.sendMessage("Hi everyone!");
    }
}