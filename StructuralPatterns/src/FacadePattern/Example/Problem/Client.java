package FacadePattern.Example.Problem;

public class Client {
    public static void main(String[] args) {
        // Client code interacting with different services directly
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        // Task
        System.out.println(userService.getUserDetails("789"));
        System.out.println(orderService.getOrderDetails("123"));
        System.out.println(paymentService.processPayment("456"));

        // Problem >
        // 1. Tight coupling
        // 2. Exposes code to client

        // Solution > Add a facade > ApiGateway
    }
}