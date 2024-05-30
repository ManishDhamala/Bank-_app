package coursework2.views;

import coursework2.BankCard;

import javax.swing.*;
import java.util.ArrayList;

public class Display extends JFrame {
    JTable table;

   // display constructor with ArrayList<BankCard> parameter
    public Display(ArrayList<BankCard> bankCards){
        super("Display");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        JPanel panel = new JPanel();
        // Header for the table
        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type"};
        //2D array of the string
        String[][] data = new String[bankCards.size()][5];
        for (int i = 0; i < bankCards.size(); i++) {
            //setting data at index i and columns
            data[i][0] = String.valueOf(bankCards.get(i).getCardId());
            data[i][1] = String.valueOf(bankCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(bankCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(bankCards.get(i).getClientName());
            data[i][4] = bankCards.get(i) instanceof coursework2.DebitCard ? "Debit Card" : "Credit Card";
        }
       // create a new table with data and columnNames
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}
