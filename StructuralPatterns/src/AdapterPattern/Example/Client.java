package AdapterPattern.Example;

public class Client {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        emailService.send("customer@tanishq.com", "order confirmation", "order has been received");

        // Problem > Won't work as sendGrid doesn't extend the Notification interface
        // NotificationService sendGridEmailService = new SendGridService();

        System.out.println("\n<<<< Changing Service >>> \n");

        // Solution > Adapter pattern
        // Adapter.send() { sendGridEmailService.sendEmail() }
        NotificationService sendGridEmailService = new SendGridAdapter(new SendGridService()); // works
        sendGridEmailService.send("customer@tanishq.com", "rewards", "click to get rewards");
    }
}