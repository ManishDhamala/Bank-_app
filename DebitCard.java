
/**
 * Write a description of class DebitCard here.
 *
 * @author (Manish Dhamala)
 * Assignment of Programming
 * 
 */
package coursework2;

public class DebitCard extends BankCard {
    // instance variable declaration
    private int pin;
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;

    // constructor
    public DebitCard(double balanceAmount, int cardId, String bankAccount,
            String issuerBank, String clientName, int pin) {
        // call superclass constructor
        super(cardId, issuerBank, bankAccount, balanceAmount);
        super.setClientName(clientName);
        super.setBalanceAmount(balanceAmount);
        this.pin = pin;

        this.hasWithdrawn = false;

    }

    // accessor(getter)
    public int getPin() {
        return this.pin;
    }

    public int getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public String getDateOfWithdrawal() {
        return this.dateOfWithdrawal;
    }

    public boolean getHasWithdrawn() {
        return this.hasWithdrawn;
    }

    // mutator(setter)
    public void setWithdrawalAmount(int WithdrawalAmount) {
        this.withdrawalAmount = WithdrawalAmount;
    }

    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pin) {

        if (this.pin == pin) {
            // comparing withdrawal amount and balance amount
            if (withdrawalAmount <= getBalanceAmount()) {
                setBalanceAmount(this.getBalanceAmount() - withdrawalAmount);
                this.withdrawalAmount = withdrawalAmount;
                this.dateOfWithdrawal = dateOfWithdrawal;
                this.hasWithdrawn = true;
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid PIN");
        }
    }

    // displaying the output
    public void display() {
        super.display();// call the display method of Bank Card class
        if (hasWithdrawn) {
            System.out.println("PIN: " + pin);
            System.out.println("Withdrawal Amount: " + withdrawalAmount);
            System.out.println("Date of Withdrawal: " + dateOfWithdrawal);
        } else
            System.out.println("No Withdrawal has been made");
    }

}
