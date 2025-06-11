package AdapterPattern.Example;

// 3rd party Service
public class SendGridService {
    // Problem > Parameters are different
    public void sendEmail(String recipient, String title, String content) {
        System.out.println("Sending email via SendGrid to " + recipient);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}