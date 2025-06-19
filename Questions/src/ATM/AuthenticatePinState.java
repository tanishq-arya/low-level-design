package ATM;

// Concrete state implementation
public class AuthenticatePinState implements ATMState {
    private final ATM atm; // reference to context object
    public AuthenticatePinState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("PIN already verified.");
    }

    @Override
    public void selectAction(ActionType action) {
        switch (action) {
            case DEPOSIT -> {
                atm.setCurrentState(atm.getTransactionState());
                System.out.println("Enter deposit amount");
            }
            case WITHDRAW -> {
                atm.setCurrentState(atm.getTransactionState());
                System.out.println("Enter withdraw amount");
            }
            case CHECK_BALANCE -> {
                System.out.println("Balance: $" + atm.getAccount().getBalance());
            }
            case EJECT -> {
                atm.setCurrentState(atm.getEjectCardState());
                atm.ejectCard();
            }
            case null, default -> {
                // Do Nothing
            }
        }
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Select deposit action first.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Select withdraw action first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Use selectAction(EJECT) to eject.");
    }
}