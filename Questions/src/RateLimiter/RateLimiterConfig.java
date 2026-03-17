package RateLimiter;

public class RateLimiterConfig {
    private final int maxRequests;
    private final int windowInSeconds;

    public RateLimiterConfig(int maxRequests, int windowInSeconds) {
        this.maxRequests = maxRequests;
        this.windowInSeconds = windowInSeconds;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public int getWindowInSeconds() {
        return windowInSeconds;
    }
}
