package ATM.Withdraw;

public class Dollar50Dispenser implements CashDispenser {
    private CashDispenser next;

    @Override
    public void setNext(CashDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(double amount) {
        if (amount >= 50) {
            int num = (int) amount / 50;
            double remainder = amount % 50;
            System.out.println("Dispensing " + num + " x $50");
            if (remainder != 0 && next != null) {
                next.dispense(remainder); // move to next chain element
            } else if (remainder != 0) {
                System.out.println("Cannot dispense remaining amount: $" + remainder);
            }
        } else if (next != null) {
            next.dispense(amount); // amount < current denomination
        }
    }
}

// Similarly for Dollar50Dispenser, Dollar20Dispenser, Dollar10Dispenser