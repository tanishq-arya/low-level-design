package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter implements RateLimiter {
    private final int limit;
    private final long windowSizeMillis;

    private static class Window {
        int count;
        long startTime;
    }

    // { user => window }
    private final ConcurrentHashMap<String, Window> userWindows = new ConcurrentHashMap<>();

    // constructor
    public FixedWindowRateLimiter(int limit, long windowSizeSeconds) {
        // config = {limit, windowSize}
        this.limit = limit;
        this.windowSizeMillis = windowSizeSeconds * 1000;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();

        userWindows.putIfAbsent(userId, new Window());
        Window window = userWindows.get(userId);
        if(now - window.startTime > windowSizeMillis) { // outside window
            // reset window
            window.startTime = now;
            window.count = 1;

            return true; // allow
        } else { // inside window
            if (window.count < limit) { // if inside limit
                window.count++;

                return  true;  // allow
            }
        }

        return false; // deny
    }
}
