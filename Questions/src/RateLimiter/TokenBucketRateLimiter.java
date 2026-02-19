package RateLimiter;

public class TokenBucketRateLimiter implements RateLimiter {

    private final long capacity;
    private final long refillRate;
    private long tokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = 0; // initially empty
        this.lastRefillTimestamp = System.nanoTime();
    }

    @Override
    public synchronized boolean allowRequest() {
        refill(); // add more tokens

        if(tokens > 0) { // if tokens available
            tokens--;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long elapsedTime = now - lastRefillTimestamp;

        long tokensToAdd = (elapsedTime / 1000000000) * refillRate;

        if (tokensToAdd > 0) {
            // fill tokens till max capacity
            tokens = Math.min(capacity, tokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
}
