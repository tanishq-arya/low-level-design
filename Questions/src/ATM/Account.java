package ATM;

public class Account {
    private final Card card;
    private double balance;
    public Account(Card card, double initialBalance) {
        this.card = card;
        this.balance = initialBalance;
    }
    public Card getCard() { return card; }
    public synchronized double getBalance() { return balance; }
    public synchronized boolean withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }
    public synchronized void deposit(double amt) {
        balance += amt;
    }
}