package AdapterPattern.Example;

public class SendGridAdapter implements NotificationService{
    private final SendGridService sendGridService;

    public SendGridAdapter(SendGridService sendGridService) {
        this.sendGridService = sendGridService;
    }

    @Override
    public void send(String to, String subject, String body) {
        // Adapter Method > convert parameters and calls to SendGrid Method
        sendGridService.sendEmail(to, subject, body);
    }
}