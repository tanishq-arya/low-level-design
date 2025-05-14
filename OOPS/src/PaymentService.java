import java.util.HashMap;

public class PaymentService {
    // Storing + Making Payments

    // In-memory data storage
    HashMap<String, PaymentMethod> paymentMethods;

    PaymentService() {
        this.paymentMethods = new HashMap<>();
    }

    public void addPaymentMethod(String name, PaymentMethod paymentMethod) {
        paymentMethods.put(name, paymentMethod);
    }

    public void makePayment(String name) {
        PaymentMethod pm = paymentMethods.get(name);
        // Runtime-Polymorphism
        // >> calls pay() based on type of PaymentMethod
        pm.pay();
    }
}
