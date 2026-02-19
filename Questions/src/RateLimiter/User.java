package RateLimiter;

enum UserType {
    NORMAL,
    PREMIUM
}

class User {
    private final String userId;
    private final UserType userType;

    public User(String userId, UserType userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public UserType getUserType() {
        return userType;
    }
}
