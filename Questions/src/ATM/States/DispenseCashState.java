package ATM.States;

import ATM.ATM;
import ATM.ATMState;
import ATM.ActionType;
import ATM.Withdraw.*;

// Concrete state implementation
public class DispenseCashState implements ATMState {
    private final ATM atm; // reference to context object
    public DispenseCashState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Dispensing. Please wait ...");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Dispensing. Please wait ...");
    }

    @Override
    public void selectAction(ActionType action) {
        System.out.println("Dispensing. Please wait ...");
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Dispensing. Please wait ...");
    }

    @Override
    public void withdraw(double amount) {
        // To keep logic simple > Go to eject state from here and exit.
//        System.out.println("Dispensing cash.");
//        atm.setCurrentState(atm.getAuthenticatePinState()); // move to next state

        // Chain of Responsibility Pattern
        // Setup chain
        CashDispenser d100 = new Dollar100Dispenser();
        CashDispenser d50 = new Dollar50Dispenser();
        CashDispenser d20 = new Dollar20Dispenser();
        CashDispenser d10 = new Dollar10Dispenser();

        d100.setNext(d50);
        d50.setNext(d20);
        d20.setNext(d10);

        System.out.println("Dispensing $" + amount + " as:");
        d100.dispense(amount);

        atm.getAccount().withdraw(amount);
        atm.setCurrentState(atm.getAuthenticatePinState()); // move to next state
    }

    @Override
    public void ejectCard() {
        System.out.println("Dispensing. Please wait ...");
    }
}