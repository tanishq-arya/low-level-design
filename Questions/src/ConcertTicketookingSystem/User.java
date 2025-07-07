package ConcertTicketookingSystem;

public class User {
    private final String name;
    private final String contactInfo;

    public User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}