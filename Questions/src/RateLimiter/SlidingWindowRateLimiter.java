package RateLimiter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter implements RateLimiter {
    int limit;
    long windowSizeMillis;

    private final ConcurrentHashMap<String, Deque<Long>> requestMap = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int limit, long windowSizeSeconds) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeSeconds * 1000;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();

        // store all allowed requests for a user
        requestMap.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> timestamps = requestMap.get(userId);

        // Remove timestamps outside window => for each starting element check if [elapsedTime > window]
        while (!timestamps.isEmpty() && now - timestamps.peekFirst() > windowSizeMillis) {
            timestamps.pollFirst();
        }

        // check if allowed requests are inside limit
        if (timestamps.size() < limit) {
            timestamps.addLast(now); // allowed => store in map
            return true;
        }

        return false; // deny
    }
}
