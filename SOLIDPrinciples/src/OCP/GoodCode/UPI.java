package OCP.GoodCode;

public class UPI implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Making payment via UPI");
    }
}
