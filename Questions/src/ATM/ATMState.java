package ATM;

public interface ATMState {
    void insertCard(String cardNumber);
    void enterPIN(String pin);
    void selectAction(ActionType action);
    void deposit(double amount);
    void withdraw(double amount);
    void ejectCard();
}