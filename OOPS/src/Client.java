public class Client {
    public static void main(String[] args) {
        System.out.println(">>>> Starting payment service >>>>");

        PaymentService ps = new PaymentService();

        ps.addPaymentMethod("TanishqCreditCard", new CreditCard("1234", "tanishq123"));
        ps.addPaymentMethod("TanishqDebitCard", new DebitCard("5678", "tanishq5678"));
        ps.addPaymentMethod("TanishqUPI", new UPI("tanishq247"));
        ps.addPaymentMethod("TanishqWallet", new Wallet());

        ps.makePayment("TanishqUPI");
        ps.makePayment("TanishqDebitCard");
    }
}