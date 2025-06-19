package ATM.States;

import ATM.ATM;
import ATM.ATMState;
import ATM.ActionType;

// Concrete state implementation
public class HasCardState implements ATMState {
    private final ATM atm; // reference to context object
    public HasCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPIN(String pin) {
        if (atm.verifyPIN(atm.getCurrentCard(), pin)) {
            atm.setCurrentState(atm.getAuthenticatePinState()); // move to next state
            System.out.println("PIN correct. Choose action.");
        } else {
            System.out.println("Wrong PIN. Try again or eject.");
        }
    }

    @Override
    public void selectAction(ActionType action) {
        System.out.println("Enter PIN first.");
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Enter PIN first.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Enter PIN first.");
    }

    @Override
    public void ejectCard() {
        // Edge case **
        atm.clearState();
        atm.setCurrentState(atm.getIdleState()); // back to base state
        System.out.println("Card ejected.");
    }
}