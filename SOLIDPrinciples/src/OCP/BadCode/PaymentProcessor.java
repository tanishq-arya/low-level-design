package OCP.BadCode;

public class PaymentProcessor {

    public void processPayment(String paymentMethod, double amount) throws IllegalAccessException {
        // business logic -> make payment based on the payment method

        // Why is this bad ?
        // Ans -> If we need to add a new payment method we need to make changes to this function
        // This violates open closed principle. (Open for extension, Closed for modification)
        switch (paymentMethod) {
            case "CreditCard" -> System.out.println("Making payment via CreditCard");
            case "DebitCard" -> System.out.println("Making payment via DebitCard");
            case "Paypal" -> System.out.println("Making payment via Paypal");
            default -> throw new IllegalAccessException("Unsupported payment method " + paymentMethod);
        }

        // Fix ? -> introduce an abstraction
    }
}
