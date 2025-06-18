package StackOverflow;

public class User {
    private final String name;
    private final String emailId;
    private int reputation;

    public User(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
        this.reputation = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getReputation() {
        return reputation;
    }

    public void updateReputation(int delta) {
        reputation += delta;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}