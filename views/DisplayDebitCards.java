package coursework2.views;

import coursework2.BankCard;
import coursework2.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayDebitCards extends JFrame {

   // DisplayDebitCards constructor with ArrayList<BankCard> parameter
    public DisplayDebitCards(ArrayList<BankCard> bankCards){
        super("Display Debit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(850, 700);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Header for the table
        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type", "PIN", "Has Withdrawn"};
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        //2D array of the string
        String[][] data = new String[debitCards.size()][7];
        for (int i = 0; i < debitCards.size(); i++) {
            try {
            //setting data at index i and columns
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(debitCards.get(i).getClientName());
            data[i][4] =  "Debit Card";
            data[i][5] = String.valueOf(debitCards.get(i).getPin());
            data[i][6] = String.valueOf(debitCards.get(i).getHasWithdrawn()); 
            //exception handling              
    } catch (Exception e) {
        System.out.println("It's not a debit card.");
    }
}       
        // create a new table with data and columnNames
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}

