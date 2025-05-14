package OCP.GoodCode;

public class PaymentProcessor {
    // This new implementation has type PaymentMethod for method
    // Follows SRP and OCP
    // Example of runtime polymorphism
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }
}
