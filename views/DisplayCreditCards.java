package coursework2.views;

import coursework2.BankCard;
import coursework2.CreditCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayCreditCards extends JFrame {

   // DisplayCreditCard constructor with ArrayList<BankCard> parameter 
    public DisplayCreditCards(ArrayList<BankCard> bankCards){
        super("Display Credit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(850, 700);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Header for the table
        String[] columnNames = {"Card ID", "Client Name", "Issuer Bank", "Bank Account","Card Type",
         "Balance Amount",  "CVC Number",  "Interest Rate",  "Expiration Date","credit limit","Is Granted"};
        ArrayList<CreditCard> CreditCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                CreditCards.add((CreditCard) bankCard);
            }
        }
        //2d array of the String
        String[][] data = new String[CreditCards.size()][11];
        for (int i = 0; i < CreditCards.size(); i++) {
            //setting data at index i and columns
            try{
            data[i][0] = String.valueOf(CreditCards.get(i).getCardId());
            data[i][1] = String.valueOf(CreditCards.get(i).getClientName());
            data[i][2] = String.valueOf(CreditCards.get(i).getIssuerBank());
            data[i][3] = String.valueOf(CreditCards.get(i).getBankAccount());
            data[i][4] =  "Credit Card";
            data[i][5] = String.valueOf(CreditCards.get(i).getBalanceAmount());
            data[i][6] = String.valueOf(CreditCards.get(i).getCvcNumber());
            data[i][7] = String.valueOf(CreditCards.get(i).getInterestRate());
            data[i][8] = String.valueOf(CreditCards.get(i).getExpirationDate());
            data[i][9] = String.valueOf(CreditCards.get(i).getCreditLimit());  
            data[i][10] = String.valueOf(CreditCards.get(i).getIsGranted());  
            }
            // exception handling
        catch (Exception e) {
            System.out.println("It's not a credit card");
          }
          //create a new table with data and columnNames 
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}
}