package ATM;

public class Client {
    public static void main(String[] args) {
        ATM atm = ATM.getInstance();

        // Sample account
        atm.addAccount(new Account(new Card("1234-5678", "4321"), 1000));
        atm.addAccount(new Account(new Card("1111-2222", "2222"), 500));

        // Simulate one session
        atm.insertCard("1234-5678");
        atm.enterPIN("4321");
        atm.selectAction(ActionType.CHECK_BALANCE);
        atm.selectAction(ActionType.WITHDRAW);
        atm.withdraw(300);
        atm.selectAction(ActionType.EJECT);
    }
}