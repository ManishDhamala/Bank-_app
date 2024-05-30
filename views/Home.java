package coursework2.views;

import javax.swing.*;

import coursework2.BankCard;
import coursework2.components.CustomButton;
import coursework2.components.CustomLabel;


import java.awt.*;
import java.util.ArrayList;

public class Home extends JFrame {

    //ArrayList can only hold objects of the BankCard and its subclasses
    ArrayList<BankCard> bankCards = new ArrayList<>();

    //Declare CustomLabel and CustomButton variables
    CustomButton addDebitCardButton, addCreditCardButton, withdrawFromDebitCardButton, setCreditLimitButton, cancelCreditCardButton, displayButton;
    CustomLabel l1;
    public Home(){
        
        //set properties of the home

        super("Manish Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);


        JPanel panel = new JPanel();
        //setting the layout of the panel to GridBagLayout
        GridBagLayout gbl = new GridBagLayout();
        //Creating a new GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setForeground(Color.BLACK);
        panel.setFont(new Font("Arial", Font.PLAIN, 25));

        //Label
        l1 = new CustomLabel("Manish Bank");
        l1.setFont(new Font("Helventica",Font.BOLD,30));
        

        //BUtton
        addDebitCardButton = new CustomButton("Add Debit Card");
        addCreditCardButton = new CustomButton("Add Credit Card");
        withdrawFromDebitCardButton = new CustomButton("Withdraw from Debit Card");
        setCreditLimitButton = new CustomButton("Set the credit limit");
        cancelCreditCardButton = new CustomButton("Cancel credit card");
        displayButton = new CustomButton("Display");

        // action listener for all the buttons passing in the "bankCards" ArrayList as a parameter.
        addDebitCardButton.addActionListener(e -> {
            new AddDebitCard(bankCards);
        });

        addCreditCardButton.addActionListener(e -> {
            new AddCreditCard(bankCards);
        });

        withdrawFromDebitCardButton.addActionListener(e -> {
            new WithdrawFromDebitCard(bankCards);
        });

        setCreditLimitButton.addActionListener(e -> {
            new SetCreditLimit(bankCards);
        });


        cancelCreditCardButton.addActionListener(e -> {
            new CancelCreditCard(bankCards);
        });

        displayButton.addActionListener(e -> {
            new Display(bankCards);
        });




        // Setting initial grid position and width
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(l1, gbc);  

     
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(addDebitCardButton, gbc);

        gbc.gridx = 4;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(addCreditCardButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        panel.add(withdrawFromDebitCardButton,gbc);

        gbc.gridx = 4;
        gbc.gridy = 14;
        gbc.gridwidth = 1;
        panel.add(setCreditLimitButton,gbc);

        gbc.gridx = 1;
        gbc.gridy = 17;
        gbc.gridwidth = 1;
        panel.add(cancelCreditCardButton,gbc);

        gbc.gridx = 4;
        gbc.gridy = 17;
        gbc.gridwidth = 1;
        panel.add(displayButton,gbc);


        // add panel to JFRame
        add(panel);
    }
}
