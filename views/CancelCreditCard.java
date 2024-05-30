package coursework2.views;

import coursework2.components.CustomButton;
import coursework2.components.CustomLabel;
import coursework2.components.CustomTextField;

import coursework2.BankCard;
import coursework2.CreditCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CancelCreditCard extends JFrame {
    //Declare CustomTextField, CustomLabel and CustomButton variables
    CustomLabel cancel_credit_card_Label, card_id_Label;
    CustomButton submitButton, clearButton;
    CustomTextField card_id_TextField;
    CreditCard creditCard ;

   // CancelCreditCard constructor with ArrayList<BankCard> parameter to store bank cards
    public CancelCreditCard(ArrayList<BankCard> bankCards){
        super("Cancel Credit Card");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);


        JPanel panel = new JPanel();
        //label
        cancel_credit_card_Label = new CustomLabel("Cancel Credit Card");
        card_id_Label = new CustomLabel("Card Id");

        //text field
        card_id_TextField = new CustomTextField("");
       //button
        submitButton = new CustomButton("Submit");
        clearButton = new CustomButton("Clear");

        //Button to submit the information
        submitButton.addActionListener(e -> {
        //Get text from cardIdTextField and trim it
        String cardId = card_id_TextField.getText().trim();
        //If cardId is empty, show a message dialog and return
        if (cardId.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Please enter a card ID");
          return;
        }

        try {
            //Convert cardId to integer
            int cardIdInt = Integer.parseInt(cardId);
            //Find credit card by cardId
            CreditCard creditCard = findCreditCardById(cardIdInt, bankCards);
            //If creditCard is not null, cancel credit card and show a message dialog
            if (creditCard != null) {
              creditCard.cancelCreditCard();
              JOptionPane.showMessageDialog(null, "Credit Card Cancelled");
            } else {
              JOptionPane.showMessageDialog(null, "Credit Card not found");
            }
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
              null,
              "Invalid card ID ! Please enter a valid number."
            );
          } finally { //Clear cardIdTextField
            clear();
          }
        });
        
        //button to clear all the components
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
        panel.add(cancel_credit_card_Label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(card_id_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(card_id_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(submitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clearButton, gbc);

        add(panel);
    }


     
 //Method to find credit card by cardId in bankCards ArrayList
  private CreditCard findCreditCardById(
    int cardId,
    ArrayList<BankCard> bankCards
    ) {
    //Loop through bankCards ArrayList
    for (BankCard card : bankCards) {
      //If card is an instance of CreditCard and cardId matches, return card
      if (card instanceof CreditCard && card.getCardId() == cardId) {
        return (CreditCard) card; //Cast card to CreditCard
      }
    }
    //If no card is found, return null
    return null;
  }

    // method to clear all the components
     public void clear(){
        card_id_TextField.setText("");
    }


}
