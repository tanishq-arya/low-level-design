package RateLimiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}