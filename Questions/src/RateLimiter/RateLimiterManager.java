package RateLimiter;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterManager {
    private final ConcurrentHashMap<String, RateLimiter> userLimiters = new ConcurrentHashMap<>();

    private RateLimiter createRateLimiter(UserType userType) {
        if (Objects.requireNonNull(userType) == UserType.PREMIUM) {
            return new SlidingWindowRateLimiter(100, 1000);
        }
        return new TokenBucketRateLimiter(100, 1);
    }

    public boolean allowRequest(User user) {
        userLimiters.putIfAbsent(user.getUserId(), createRateLimiter(user.getUserType()));

        return userLimiters.get(user.getUserId()).allowRequest();
    }


}
