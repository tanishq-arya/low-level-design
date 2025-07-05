package RestaurantManagementSystem;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String name;
    private final String contactInfo;

    public Customer(String name, String contactInfo) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
}