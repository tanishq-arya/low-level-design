package ATM;

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
        System.out.println("Dispensing cash.");
        atm.setCurrentState(atm.getAuthenticatePinState()); // move to next state

        // To keep logic simple > Go to eject state from here and exit.
    }

    @Override
    public void ejectCard() {
        System.out.println("Dispensing. Please wait ...");
    }
}