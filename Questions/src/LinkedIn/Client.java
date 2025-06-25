package LinkedIn;

import LinkedIn.Services.LinkedInService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        LinkedInService service = LinkedInService.getInstance();

        // 1. Register two users
        User alice = service.register("Alice", "alice@example.com", "password123");
        User bob = service.register("Bob", "bob@example.com", "secure456");

        // 2. Login as Alice (receives a session token)
        String aliceToken = service.login("alice@example.com", "password123");
        System.out.println("Alice logged in with token: " + aliceToken);

        // 3. Create Alice’s profile
        service.createProfile(aliceToken, "Alice", "Engineer at Acme Inc.", List.of("Java", "Distributed Systems"));

        // 4. Login as Bob
        String bobToken = service.login("bob@example.com", "secure456");
        System.out.println("Bob logged in with token: " + bobToken);

        // 5. Alice sends a connection request to Bob
        service.sendConnectionRequest(aliceToken, bob.getId());
        // Bob fetches notifications
        List<Notification> bobNotifs = service.getNotifications(bobToken);
        System.out.println("Bob’s notifications after request:");
        bobNotifs.forEach(n -> System.out.println(" - " + n.getType() + ": " + n.getPayload()));

        // 6. Bob accepts the connection request
//        ConnectionRequest req = service.listPendingRequests(bobToken).get(0);
//        service.respondConnectionRequest(bobToken, req.getId(), true);

        // 7. Alice posts a job via her company account
        User acme = service.register("Acme Inc.", "acme@gamil.com", "1234");
        JobPost job = service.postJob(aliceToken, "Senior Engineer", "Design scalable systems", acme);
        System.out.println("Job posted: " + job.getTitle());

        // 8. Bob sends Alice a message
        service.sendMessage(bobToken, alice.getId(), "Congrats on the new job posting!");
        // Alice checks her notifications
        List<Notification> aliceNotifs = service.getNotifications(aliceToken);
        System.out.println("Alice’s notifications:");
        aliceNotifs.forEach(n -> System.out.println(" - " + n.getType() + ": " + n.getPayload()));

        // 9. Alice reads her messages
        List<Message> conversation = service.fetchConversation(aliceToken, bob.getId());
        System.out.println("Conversation between Alice and Bob:");
        conversation.forEach(m ->
                System.out.printf(" [%s → %s] %s%n", m.getFrom().getName(), m.getTo().getName(), m.getContent())
        );

        // 10. Logout both users
        service.logout(aliceToken);
        service.logout(bobToken);
        System.out.println("Demo complete.");
    }
}