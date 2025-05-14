package OCP.GoodCode;

public class Client {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod creditCard = new CreditCard();

        processor.processPayment(creditCard, 100);

        // We can add a new payment method -> via extension / inheritance
        PaymentMethod upi = new UPI();
        processor.processPayment(upi, 100);
    }
}