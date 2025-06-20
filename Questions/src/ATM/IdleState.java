package ATM;

// Concrete state implementation
public class IdleState implements ATMState {
    private final ATM atm; // reference to context object

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        if (atm.isValidCard(cardNumber)) {
            atm.setCurrentCard(cardNumber);
            atm.setCurrentState(atm.getHasCardState()); // move to next state
            System.out.println("Card accepted. Please enter PIN.");
        } else {
            System.out.println("Invalid card.");
        }
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Insert card first.");
    }

    @Override
    public void selectAction(ActionType action) {
        System.out.println("Insert card first.");
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }
}