package ATM.Withdraw;

public class Dollar10Dispenser implements CashDispenser {
    private CashDispenser next;

    @Override
    public void setNext(CashDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(double amount) {
        if (amount >= 10) {
            int num = (int) amount / 10;
            double remainder = amount % 10;
            System.out.println("Dispensing " + num + " x $10");
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

// Similarly for Dollar10Dispenser, Dollar20Dispenser, Dollar10Dispenser