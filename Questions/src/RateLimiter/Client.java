package RateLimiter;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterManager manager = new RateLimiterManager();
        User normalUser = new User("user1", UserType.NORMAL);
        User premiumUser = new User("user2", UserType.PREMIUM);

        // normal user calls
        for (int i=1; i<=5; i++) {
            boolean allowed = manager.allowRequest(normalUser);
            System.out.println("Normal req " + i + ": " + allowed);
            Thread.sleep(500); // 0.5 second gap
        }

        // premium user calls
        for (int i=1; i<=7; i++) {
            boolean allowed = manager.allowRequest(premiumUser);
            System.out.println("Premium req " + i + ": " + allowed);
            Thread.sleep(500); // 0.5 second gap
        }
    }
}
