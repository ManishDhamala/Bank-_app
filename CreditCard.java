
/**
 * Write a description of class CreditCard here.
 *
 * @author (Manish Dhamala)
 * Assignment of Programming
 */
package coursework2;

public class CreditCard extends BankCard {
    // instance variable declaration
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;

    // constructor
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount,
            double balanceAmount, int cvcNumber, double interestRate, String expirationDate) {
        // call superclass constructor
        super(cardId, issuerBank, bankAccount, balanceAmount);
        super.setClientName(clientName);
        super.setBalanceAmount(balanceAmount);

        this.cvcNumber = cvcNumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;

        this.isGranted = false;
    }

    // accessor(getter)
    public int getCvcNumber() {
        return this.cvcNumber;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public int getGracePeriod() {
        return this.gracePeriod;
    }

    public boolean getIsGranted() {
        return this.isGranted;
    }

    // mutator(setter)
    public void setCreditLimit(double creditLimit, int gracePeriod) {
        if (creditLimit <= 2.5 * getBalanceAmount()) {
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            this.isGranted = true;
        } else {
            System.out.println("Credit cannot be issued");
        }
    }

    public void cancelCreditCard() {
        if (isGranted) {
            this.cvcNumber = 0;
            this.creditLimit = 0;
            this.gracePeriod = 0;
            this.isGranted = false;
        } else {
            System.out.println("Credit card has not been granted");
        }
    }

    // displaying the output
    public void display() {
        super.display();// call the display method of Bank Card class
        if (isGranted) {
            System.out.println("CVC Number: " + cvcNumber);
            System.out.println("Credit Limit: " + creditLimit);
            System.out.println("Interest Rate: " + interestRate);
            System.out.println("Expiration Date: " + expirationDate);
            System.out.println("Grace Period: " + gracePeriod);
        } else {
            System.out.println(" credit has not been allowed");
        }
    }
}
