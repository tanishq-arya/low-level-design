public class Card implements PaymentMethod{
    private String cardNo;

    private String userName;

    public Card(String cardNo, String userName) {
        this.cardNo = cardNo;
        this.userName = userName;
    }

    // Pay method
    @Override
    public void pay() {
        // will be implemented by the child
    }

    // Getter(s) for the properties
    public String getUserName() {
        return userName;
    }

    public String getCardNo() {
        return cardNo;
    }

    // Setter(s) for the properties
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}