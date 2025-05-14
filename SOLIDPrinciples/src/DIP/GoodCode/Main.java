package DIP.GoodCode;

public class Main {
    public static void main(String[] args) {
        NotificationService emailNotification = new NotificationService(new EmailService());
        emailNotification.notify("Your order has been shipped");

        NotificationService smsNotification = new NotificationService(new SmsService());
        smsNotification.notify("Your otp is 1234");

        // Reduced Coupling -> This code is flexible
        // High-Level Module [NotificationService] is independent of NotificationChannel
        // Scalable & Maintainable Testing is easier now
    }
}
