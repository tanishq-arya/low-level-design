package RateLimiter;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        UserRateLimiterService service = new UserRateLimiterService();
        User normalUser = new User("user1", UserType.NORMAL);
        User premiumUser = new User("user2", UserType.PREMIUM);

//        // normal user calls
//        for (int i=1; i<=5; i++) {
//            boolean allowed = service.allowRequest(normalUser);
//            System.out.println("Normal req " + i + ": " + allowed);
//            Thread.sleep(500); // 0.5 second gap
//        }
//
//        // premium user calls
//        for (int i=1; i<=7; i++) {
//            boolean allowed = service.allowRequest(premiumUser);
//            System.out.println("Premium req " + i + ": " + allowed);
//            Thread.sleep(500); // 0.5 second gap
//        }

        // testing other rate limiters
        for (int i=1; i<=7; i++) {
            boolean allowed = service.allowRequest(premiumUser, RateLimiterType.FIXED_WINDOW);
            System.out.println("Premium req " + i + ": " + allowed);
            Thread.sleep(500); // 0.5 second gap
        }
    }
}
