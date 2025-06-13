package FacadePattern.Example.Solution;

public class APIGateway {
    UserService userService;
    OrderService orderService;
    PaymentService paymentService;

    public APIGateway() {
        userService = new UserService();
        orderService = new OrderService();
        paymentService = new PaymentService();
    }

    // Task
    public String getFullOrderDetails(String userId, String orderId, String paymentId) {
        String userDetails = userService.getUserDetails(userId);
        String orderDetails = orderService.getOrderDetails(orderId);
        String paymentDetails = paymentService.processPayment(paymentId);

        return userDetails + "\n" + orderDetails + "\n" + paymentDetails;
    }
}