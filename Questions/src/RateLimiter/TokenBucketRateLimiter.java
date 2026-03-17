package RateLimiter;

// Most Preferred for Interviews
public class TokenBucketRateLimiter implements RateLimiter {
    public TokenBucketRateLimiter(RateLimiterConfig config) {
    }

    @Override
    public boolean allowRequest(String userId) {
        return false;
    }
}
