package SRP.BadCode;

public class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    // Additional Functionality
    // Bad why ? -> This doesn't make sense as if any single functionality changes,
    // this class needs to be updated -> Hence, violates Single responsibility principle
    public void generateInvoice() {
        System.out.println("Invoice generated & printed for amount: " + amount);
    }

    public void saveToDatabase() {
        System.out.println("Saving invoice to database");
    }

    public void sendEmailNotification() {
        System.out.println("Sending email notification for invoice");
    }
}
