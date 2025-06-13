package FacadePattern.Example.Solution;

public class Client {
    public static void main(String[] args) {
        // Solution > Add a facade > ApiGateway
        // Client code interacting with single API Gateway (Facade)
        APIGateway apiGateway = new APIGateway();

        // Task
        System.out.println(apiGateway.getFullOrderDetails("123", "456", "789"));

        // 1. Client code simplified
        // 2. Decoupling > Any changes in microservice is handled by gateway
        // 3. Centralized control > security, logging, rate limiting
    }
}