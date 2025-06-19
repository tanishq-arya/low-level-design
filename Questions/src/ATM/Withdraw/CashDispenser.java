package ATM.Withdraw;

public interface CashDispenser {
    void setNext(CashDispenser next);
    void dispense(double amount);
}