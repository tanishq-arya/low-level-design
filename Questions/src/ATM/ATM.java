package ATM;

import ATM.States.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ATM {
    // Singleton instance
    private static ATM instance;

    // States
    private final ATMState idleState;
    private final ATMState hasCardState;
    private final ATMState authenticatePinState;
    private final ATMState transactionState;
    private final ATMState dispenseCashState;
    private final ATMState ejectCardState;

    // Resources/References for ATM
    private ATMState currentState;
    private String currentCard;

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();
    private final CashInventory cashInventory = new CashInventory();

    private ATM() {
        idleState = new IdleState(this);
        hasCardState = new HasCardState(this);
        authenticatePinState = new AuthenticatePinState(this);
        transactionState = new TransactionState(this);
        dispenseCashState = new DispenseCashState(this);
        ejectCardState = new EjectCardState(this);

        // init ATM state variables
        currentState = idleState;
        currentCard = null;
    }

    // Important **
    // Singleton Pattern & thread-safe using synchronized
    public static synchronized ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }

    // Delegate methods
    public void insertCard(String cardNumber) {
        currentState.insertCard(cardNumber);
    }

    public void enterPIN(String pin) {
        currentState.enterPIN(pin);
    }

    public void selectAction(ActionType action) {
        currentState.selectAction(action);
    }

    public void deposit(double amount) {
        currentState.deposit(amount);
    }

    public void withdraw(double amount) {
        currentState.withdraw(amount);
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    // Account & Card helpers
    public void addAccount (Account account) {
        accounts.put(account.getCard().getNumber(), account);
    }

    public void setCurrentCard(String currentCard) {
        this.currentCard = currentCard;
    }

    // Validate Card
    public boolean isValidCard(String cardNumber) {
        return accounts.containsKey(cardNumber); // check if exists in map
    }

    // Verify PIN
    public boolean verifyPIN(String cardNumber, String pin) {
        // Assuming here to be correct > come back later
        return accounts.get(cardNumber).getCard().verifyPIN(pin);
    }

    public Account getAccount() {
        return accounts.get(getCurrentCard());
    }

    // State setters & getters
    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public String getCurrentCard() {
        return currentCard;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getAuthenticatePinState() {
        return authenticatePinState;
    }

    public ATMState getTransactionState() {
        return transactionState;
    }

    public ATMState getDispenseCashState() {
        return dispenseCashState;
    }

    public ATMState getEjectCardState() {
        return ejectCardState;
    }

    public CashInventory getCashInventory() {
        return cashInventory;
    }

    // Clear state
    public void clearState() {
        currentCard = null;
        currentState = null;
    }
}