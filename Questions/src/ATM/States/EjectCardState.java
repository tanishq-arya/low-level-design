package ATM.States;

import ATM.ATM;
import ATM.ATMState;
import ATM.ActionType;

// Concrete state implementation
public class EjectCardState implements ATMState {
    private final ATM atm; // reference to context object
    public EjectCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Card ejected.");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Card ejected.");
    }

    @Override
    public void selectAction(ActionType action) {
        System.out.println("Card ejected.");
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Card ejected.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Card ejected.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected. Thank you.");
        atm.clearState();
        atm.setCurrentState(atm.getIdleState()); // back to base state
    }
}