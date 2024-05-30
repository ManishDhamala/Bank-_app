package coursework2.views;

import coursework2.BankCard;
import coursework2.CreditCard;

import coursework2.components.CustomButton;
import coursework2.components.CustomLabel;
import coursework2.components.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SetCreditLimit extends JFrame {
    //Declare CustomTextField,CustomLabel and CustomButton variables
    CustomButton setButton, clearButton;
    CustomLabel  set_credit_limit_Label, card_id_Label, new_credit_limit_Label, new_grace_period_Label;

    CustomTextField card_id_TextField, new_credit_limit_TextField, new_grace_period_TextField;
   // SetCreditLimit constructor with ArrayList<BankCard> parameter to store bank cards
    public SetCreditLimit(ArrayList<BankCard> bankCards){
        super("Set Credit Limit");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        //Label
        set_credit_limit_Label = new CustomLabel("Set Credit Limit");
        card_id_Label = new CustomLabel("Card Id");
        new_credit_limit_Label = new CustomLabel("New Credit Limit");
        new_grace_period_Label = new CustomLabel("New Grace Period");

        //Text field
        card_id_TextField = new CustomTextField("");
        new_credit_limit_TextField = new CustomTextField("");
        new_grace_period_TextField = new CustomTextField("");

        //Button
        setButton = new CustomButton("Set");
        clearButton = new CustomButton("Clear");



    // setButton to set the credit limit
    setButton.addActionListener(e -> {
        // Get inputs from text fields
        String cardId = card_id_TextField.getText();
        String creditLimit = new_credit_limit_TextField.getText();
        String gracePeriod = new_grace_period_TextField.getText();
  
        if (cardId.isEmpty() || creditLimit.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Please fill all the fields");
          return;
        }
  
        try {
          //extract the contents from the text fields, transform them to the correct type,
          int cardIdInt = Integer.parseInt(cardId);
          double creditLimitDouble = Double.parseDouble(creditLimit);
          int gracePeriodInt = Integer.parseInt(gracePeriod);
  
          // Check if  the inputs are positive or not
          if (cardIdInt < 0 || creditLimitDouble < 0 || gracePeriodInt < 0) {
            JOptionPane.showMessageDialog(
              null,
              "Invalid input ! Card ID, Credit Limit, and Grace Period should be greater than zero"
            );
            return;
          }
  
          // Find the credit card with the given card ID
          CreditCard creditCard = findCreditCard(cardIdInt, bankCards);
          if (creditCard == null) {
            JOptionPane.showMessageDialog(null, " Not a Credit Card");
            return;
          }
  
          // Check if the credit limit can be issued or not
          double balanceAmount = creditCard.getBalanceAmount();
          if (creditLimitDouble > 2.5 * balanceAmount) {
            JOptionPane.showMessageDialog(
              null,
              "Credit cannot be issued because credit limit exceeds 2.5 times than the current balance"
            );
            return;
          }
  
          // Setting the credit Limit and grace Period
          creditCard.setCreditLimit(creditLimitDouble, gracePeriodInt);
          JOptionPane.showMessageDialog(null, "Credit Limit set successfully");
          clear();
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(
            null,
            "Invalid input ! please enter valid numbers for Card ID, Credit Limit, and Grace Period"
          );
        }
      });


        // Button to clear all the components
        clearButton.addActionListener(e -> {
            clear();
        });
        //setting the layout of the panel to GridBagLayout
        GridBagLayout gbl = new GridBagLayout();
        //Creating a new GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        // Setting initial grid position and width 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(set_credit_limit_Label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(card_id_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(card_id_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new_credit_limit_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(new_credit_limit_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new_grace_period_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(new_grace_period_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(setButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(clearButton, gbc);

        add(panel);
    }



      //Method to find the CreditCard with the given card ID in the given ArrayList of BankCards
        private CreditCard findCreditCard(int cardId, ArrayList<BankCard> bankCards) {
        for (BankCard card : bankCards) {
      if (card.getCardId() == cardId && card instanceof CreditCard) {
        return (CreditCard) card;
      }
    }
     return null;
    }
    // method to clear all the components
    public void clear(){
        card_id_TextField.setText("");
        new_credit_limit_TextField.setText("");
        new_grace_period_TextField.setText("");
    }
}
