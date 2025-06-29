package CarRentalSystem;

public class Customer {
    private final String id;
    private final String name;
    private final String contactInfo;
    private final String driverLicenseNumber;

    public Customer(String id, String name, String contactInfo, String driverLicenseNumber) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
    public String getDriverLicenseNumber() { return driverLicenseNumber; }
}