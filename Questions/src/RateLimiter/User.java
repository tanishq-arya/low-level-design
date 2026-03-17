package RateLimiter;

public class User {
    private final String userId;
    private UserType userType;

    public User(String userId, UserType userType) {
        this.userId = userId;
        this.userType = userType;
    }

    // getters
    public String getUserId() {return userId;}
    public UserType getUserType() {return userType;}

    // setters
    public void setUserType(UserType userType) {this.userType = userType;}
}
