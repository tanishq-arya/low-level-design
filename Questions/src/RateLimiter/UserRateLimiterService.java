package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class UserRateLimiterService {
    private final ConcurrentHashMap<String, RateLimiter> userLimiters = new ConcurrentHashMap<>();

    public boolean allowRequest(User user) {
        // Create a RateLimiter for that user if it doesn't exist already
        userLimiters.putIfAbsent(user.getUserId(), RateLimiterFactory.create(user.getUserType()));

        return userLimiters.get(user.getUserId()).allowRequest(user.getUserId());
    }

    public boolean allowRequest(User user, RateLimiterType type) {
        // Create a RateLimiter for that user if it doesn't exist already
        userLimiters.putIfAbsent(user.getUserId(), RateLimiterFactory.create(type));

        return userLimiters.get(user.getUserId()).allowRequest(user.getUserId());
    }

}
