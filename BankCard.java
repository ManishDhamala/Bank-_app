
/**
 * Write a description of class BankCard here.
 *
 * @author (Manish Dhamala)
 * Assignment of Programming
 */
package coursework2;

public class BankCard {
    // instance variable declaration
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;

    // constructor
    public BankCard(int cardId, String issuerBank,
            String bankAccount, double balanceAmount) {
        this.cardId = cardId;
        this.clientName = "";
        this.issuerBank = issuerBank;
        this.bankAccount = bankAccount;
        this.balanceAmount = balanceAmount;
    }


    // getters
    public int getCardId() {
        return this.cardId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getIssuerBank() {
        return this.issuerBank;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public double getBalanceAmount() {
        return this.balanceAmount;
    }

    //  setter
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    // display method
    public void display() {

        // check if client name is assigned or not
        if (clientName.equals("")) {
            System.out.println("Client Name has not assigned");
        } else {
            System.out.println("Card ID: " + cardId);
            System.out.println("Client Name: " + clientName);
            System.out.println("Issuer Bank: " + issuerBank);
            System.out.println("Bank Account: " + bankAccount);
            System.out.println("Balance Amount: " + balanceAmount);
        }

    }
}
