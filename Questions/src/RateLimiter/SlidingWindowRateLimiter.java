package RateLimiter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Deque<Long> requestTimestamps;

    public SlidingWindowRateLimiter(int maxRequests, int windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestTimestamps = new ArrayDeque<>();
    }

    @Override
    public boolean allowRequest() {
        long now = System.currentTimeMillis();

        // remove from start => outside window
        while(!requestTimestamps.isEmpty() && now - requestTimestamps.peekFirst() > windowSizeInMillis) {
            requestTimestamps.pollFirst();
        }

        // check if we can allow new requests or not
        if(requestTimestamps.size() < maxRequests) {
            requestTimestamps.addLast(now);
            return true;
        }

        return false;
    }
}
