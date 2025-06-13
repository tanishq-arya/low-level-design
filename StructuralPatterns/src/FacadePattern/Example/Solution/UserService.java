package FacadePattern.Example.Solution;

// Microservice for user details
public class UserService {
    public String getUserDetails(String userId) {
        // Simulate fetching user details
        return "Get user details from DB for userId: " + userId;
    }
}