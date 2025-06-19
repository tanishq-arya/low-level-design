package ATM.Withdraw;

public class Dollar100Dispenser implements CashDispenser {
    private CashDispenser next;

    @Override
    public void setNext(CashDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(double amount) {
        if (amount >= 100) {
            int num = (int) amount / 100;
            double remainder = amount % 100;
            System.out.println("Dispensing " + num + " x $100");
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