package RateLimiter;

// Factory to create different rateLimiters based on user tier / type
public class RateLimiterFactory {

    public static RateLimiter create(UserType type) {
        if (type == UserType.PREMIUM) {
            // 20 requests / 10 seconds
            return new TokenBucketRateLimiter(new RateLimiterConfig(20, 10)); // higher capacity
        } else {
            return new TokenBucketRateLimiter(new RateLimiterConfig(10, 5));
        }
    }

    public static RateLimiter create(RateLimiterType type) {
        if (type == RateLimiterType.FIXED_WINDOW) {
            return new FixedWindowRateLimiter(3, 5);
        } else if (type == RateLimiterType.SLIDING_WINDOW) {
            return new SlidingWindowRateLimiter(5, 10);
        }

        return null;
    }
}
