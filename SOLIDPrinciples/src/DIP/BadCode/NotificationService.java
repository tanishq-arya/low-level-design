package DIP.BadCode;

public class NotificationService {
    private EmailService emailService;

    private SMSService smsService;

    public NotificationService() {
        this.emailService = new EmailService();
        this.smsService = new SMSService();
    }

    public void notifyByEmail(String msg) {
        emailService.sendEmail(msg);
    }

    public void notifyBySms(String msg) {
        smsService.sendSms(msg);
    }

    // Problems -> tightly coupled -> depends on how the services are implemented
    // Testing is not easy
    // Violates DIP -> NotificationService is dependent on low level EmailService and SmsService
}
