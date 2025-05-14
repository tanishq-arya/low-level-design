public class UPI implements PaymentMethod{
    String id;

    public UPI(String id) {
        this.id = id;
    }

    @Override
    public void pay() {
        System.out.println("Making payment via UPI");
    }
}