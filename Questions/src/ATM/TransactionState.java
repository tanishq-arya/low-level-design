package ATM;

// Concrete state implementation
public class TransactionState implements ATMState {
    private final ATM atm; // reference to context object
    public TransactionState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("In transaction. Enter amount.");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("In transaction. Enter amount.");
    }

    @Override
    public void selectAction(ActionType action) {
        System.out.println("In transaction. Enter amount.");
    }

    @Override
    public void deposit(double amount) {
        atm.getAccount().deposit(amount); // update account
        atm.getCashInventory().acceptDeposit(amount);  // update inventory
        System.out.println("Deposited: " + amount);
        atm.setCurrentState(atm.getAuthenticatePinState()); // move to next state
    }

    @Override
    public void withdraw(double amount) {
        if (!atm.getAccount().withdraw(amount)) {
            System.out.println("Insufficient funds.");
            atm.setCurrentState(atm.getAuthenticatePinState());  // move to next state
            return;
        }

        atm.setCurrentState(atm.getDispenseCashState()); // move to next state
        atm.withdraw(amount);
    }

    @Override
    public void ejectCard() {
        System.out.println("Complete transaction first.");
    }
}