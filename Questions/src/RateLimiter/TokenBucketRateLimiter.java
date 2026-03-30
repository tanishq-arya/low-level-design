package RateLimiter;

// Most Preferred for Interviews
public class TokenBucketRateLimiter implements RateLimiter {
    private final int capacity;
    private final double refillRatePerMs;

    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int capacity, double refillPerSecond) {
        this.capacity = capacity;
        this.refillRatePerMs = refillPerSecond / 1000.0;

        this.tokens = capacity; // full initially
        this.lastRefillTime = System.currentTimeMillis(); // refilled now
    }

    @Override
    public boolean allowRequest(String userId) {
        refillTokens();

        if(tokens >= 1) {
            tokens -= 1;
            return true; // allow this request
        }

        return false; // deny
    }

    private void refillTokens() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastRefillTime;

        // update tokens
        tokens = Math.min(
                capacity,
                tokens + elapsed * refillRatePerMs
        );

        lastRefillTime = now;
    }
}
