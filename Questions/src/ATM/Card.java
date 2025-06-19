package ATM;

public class Card {
    private final String number;
    private final String pin;
    public Card(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }
    public String getNumber() { return number; }
    public boolean verifyPIN(String attempt) {
        return pin.equals(attempt);
    }
}