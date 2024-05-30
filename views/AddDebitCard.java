package coursework2.views;

import coursework2.BankCard;
import coursework2.DebitCard;
import coursework2.components.CustomButton;
import coursework2.components.CustomLabel;
import coursework2.components.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddDebitCard extends JFrame {
    //Declare CustomTextField,CustomLabel and CustomButton variables
    CustomTextField balance_amount_TextField, card_id_TextField, bank_account_TextField, issuer_bank_TextField, client_name_TextField, pin_TextField;
    CustomButton addButton, clearButton, displayButton;
    CustomLabel add_debitcard_Label, balance_amount_Label, card_id_Label, bank_account_Label, issuer_bank_Label, client_name_Label, pin_Label;

   // AddDebitCard constructor with ArrayList<BankCard> parameter to store bank cards
    public AddDebitCard(ArrayList<BankCard> bankCards){
        super("Add Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        //Label
        add_debitcard_Label = new CustomLabel("Add Debit Card");
        balance_amount_Label = new CustomLabel("Balance Amount");
        card_id_Label = new CustomLabel("Card Id");
        bank_account_Label = new CustomLabel("Bank Account");
        issuer_bank_Label = new CustomLabel("Issuer Bank");
        client_name_Label = new CustomLabel("Client Name");
        pin_Label = new CustomLabel("PIN");

        //Text Field
        balance_amount_TextField = new CustomTextField("");
        card_id_TextField = new CustomTextField("");
        bank_account_TextField = new CustomTextField("");
        issuer_bank_TextField = new CustomTextField("");
        client_name_TextField = new CustomTextField("");
        pin_TextField = new CustomTextField("");

        //button
        addButton = new CustomButton("Add");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");

        //creating a button to add debit card
        addButton.addActionListener(e -> {
            try {
              //Get the text from the text fields
              String balanceAmount = balance_amount_TextField.getText();
              String cardId = card_id_TextField.getText();
              String bankAccount = bank_account_TextField.getText();
              String issueBank = issuer_bank_TextField.getText();
              String clientName = client_name_TextField.getText();
              String pin = pin_TextField.getText();
      
              
              if (
                balanceAmount.equals("") ||
                cardId.equals("") ||
                bankAccount.equals("") ||
                issueBank.equals("") ||
                clientName.equals("") ||
                pin.equals("")
              ) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
              }
              // check if the card ID already exists
              else if (isCardIdExists(bankCards, cardId)) {
                JOptionPane.showMessageDialog(
                  null,
                  "Invalid input ! card ID already exists"
                );
                return;
              }
              //Check if the input value contain valid integer and double 
              else if (
                !cardId.matches("\\d+") ||
                !pin.matches("\\d+") ||
                !balanceAmount.matches("\\d+(\\.\\d+)?")
              ) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers ");
              }
              //Create a new DebitCard object, extract the contents from the text fields, transform them to the correct type, and display a message 
              else {
                try {
                  double balance = Double.parseDouble(balanceAmount);
                  int card = Integer.parseInt(cardId);
                  int pinNumber= Integer.parseInt(pin);
                  DebitCard debitCard = new DebitCard(
                    balance,
                    card,
                    bankAccount,
                    issueBank,
                    clientName,
                    pinNumber
                  );
                  bankCards.add(debitCard);
                  JOptionPane.showMessageDialog(
                    null,
                    "Debit Card added successfully"
                  );
                  clear();
                } catch (Exception ex) {
                    // Handle exception for invalid input
                  JOptionPane.showMessageDialog(null, "Please enter valid input.");
                }
              }
            } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(
                null,
                "Please enter valid number for the Balance amount, Card ID, and PIN "
              );
              ex.printStackTrace();
            } catch (Exception ex) {
              JOptionPane.showMessageDialog(
                null,
                "An error occurred: " + ex.getMessage()
              );
              ex.printStackTrace();
            }
          });

          // button to clear all the components
        clearButton.addActionListener(e -> {
            clear();
        });

        //button to display debit card information from the bankcard list
        displayButton.addActionListener(e -> {
            new DisplayDebitCards(bankCards);
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
        panel.add(add_debitcard_Label, gbc);



        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(balance_amount_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(balance_amount_TextField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(card_id_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(card_id_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(bank_account_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(bank_account_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(issuer_bank_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(issuer_bank_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(client_name_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(client_name_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(pin_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(pin_TextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panel.add(addButton, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(clearButton, gbc);


        gbc.gridx = 2;
        gbc.gridy = 7;
        panel.add(displayButton, gbc);

        add(panel);
    }

    private boolean isCardIdExists(ArrayList<BankCard> bankCards, String cardId) {
        for (BankCard card : bankCards) {
          if (
            card instanceof DebitCard &&
            ((DebitCard) card).getCardId() == Integer.parseInt(cardId)
          ) {
            return true;
          }
        }
        return false;
    }

    // method to clear all the components
    public void clear() {
        balance_amount_TextField.setText("");
        card_id_TextField.setText("");
        bank_account_TextField.setText("");
        issuer_bank_TextField.setText("");
        client_name_TextField.setText("");
        pin_TextField.setText("");
    }
}
