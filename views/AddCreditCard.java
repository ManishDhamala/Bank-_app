package coursework2.views;

import coursework2.BankCard;
import coursework2.CreditCard;
import coursework2.components.CustomButton;
import coursework2.components.CustomComboBox;
import coursework2.components.CustomLabel;
import coursework2.components.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCreditCard extends JFrame {
    //Declare CustomTextField,CustomComboBox,CustomLabel and CustomButton variables
    CustomTextField cardidTextField, clientnameTextField, issuerbankTextField, bankaccountTextField, balanceamountTextField, cvcnumberTextField, interestrateTextField, expirationdateTextField;
    CustomComboBox c1, c2, c3;
    CustomLabel addcreditcardLabel, cardidLabel, clientnameLabel, issuerbankLabel, bankaccountLabel, balanceamountLabel, cvcnumberLabel, interestrateLabel, expirationdateLabel;
    CustomButton addButton, clearButton, displayButton;
   // AddCreditCard constructor with ArrayList<BankCard> parameter to store bank cards
    public AddCreditCard(ArrayList<BankCard> bankCards){
        super("Add Credit Card");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        //setting the layout of the panel to GridBagLayout
        GridBagLayout gbl = new GridBagLayout();
        //Creating a new GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        //Label
        addcreditcardLabel = new CustomLabel("Add Credit Card");
        cardidLabel = new CustomLabel("Card Id");
        clientnameLabel = new CustomLabel("Client Name");
        issuerbankLabel = new CustomLabel("Issuer Bank");
        bankaccountLabel = new CustomLabel("Bank Account");
        balanceamountLabel = new CustomLabel("Balance Amount");
        cvcnumberLabel = new CustomLabel("CVC Number");
        interestrateLabel = new CustomLabel("Interest Rate");
        expirationdateLabel = new CustomLabel("Expiration Date");

        //Text Field
        cardidTextField = new CustomTextField("");
        clientnameTextField = new CustomTextField("");
        issuerbankTextField = new CustomTextField("");
        bankaccountTextField = new CustomTextField("");
        balanceamountTextField = new CustomTextField("");
        cvcnumberTextField = new CustomTextField("");
        interestrateTextField = new CustomTextField("");
        expirationdateTextField = new CustomTextField("");

        // coombo box for years
        c1 = new CustomComboBox(new String[]{
                "select year", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"});
        // combo box for months
        c2 = new CustomComboBox(new String[]{
                "select month",
                "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October","November","December"});
        // combo box for days
        c3 = new CustomComboBox(new String[]{"select day",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20",
        		"21","22","23","24","25","26","27","28","29","30","31"});


         //button       
        addButton = new CustomButton("Add");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");


    //creating a button to add credit card
    addButton.addActionListener(e -> {
        try {
          //get text from the text fields
          String cardId = cardidTextField.getText();
          String clientName = clientnameTextField.getText();
          String issuerBank = issuerbankTextField.getText();
          String bankAccount = bankaccountTextField.getText();
          String balanceAmount = balanceamountTextField.getText();
          String cvcNumber = cvcnumberTextField.getText();
          String interestRate = interestrateTextField.getText();
          String expirationDate =
            c1.getSelectedItem() +
            " " +
            c2.getSelectedItem() +
            " " +
            c3.getSelectedItem();
  
          if (
            cardId.equals("") ||
            clientName.equals("") ||
            issuerBank.equals("") ||
            bankAccount.equals("") ||
            balanceAmount.equals("") ||
            cvcNumber.equals("") ||
            interestRate.equals("") ||
            expirationDate.equals("")||
            c1.getSelectedIndex() == 0 ||
            c2.getSelectedIndex() == 0 ||
            c3.getSelectedIndex() == 0
          ) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields.");
          }
          // Check if the input value are number or not
          else if (
            !cardId.matches("\\d+") ||
            !balanceAmount.matches("\\d+(\\.\\d+)?") ||
            !cvcNumber.matches("\\d+") ||
            !interestRate.matches("\\d+(\\.\\d+)?")
          ) {
            JOptionPane.showMessageDialog(
              null,
              "Invalid input ! Please enter a valid number."
            );
          }
          //check if input values are letters or not
          else if (
            !clientName.matches("[a-zA-Z]+( [a-zA-Z]+)*") ||
            !issuerBank.matches("[a-zA-Z]+( [a-zA-Z]+)*")
          ) {
            JOptionPane.showMessageDialog(
              null,
              "Invalid input ! Please enter a valid name."
            );
          }
          // check if card ID already exists
          else if (isCardIdExists(bankCards, cardId)) {
            JOptionPane.showMessageDialog(
              null,
              "Invalid input! card ID already exists"
            );
            return;
          }
        //Create a new CreditCard object, extract the contents from the text fields, transform them to the correct type, and display a message 
          else {
            int card = Integer.parseInt(cardId);
            double balance = Double.parseDouble(balanceAmount);
            int cvc = Integer.parseInt(cvcNumber);
            double interest = Double.parseDouble(interestRate);
            CreditCard creditCard = new CreditCard(
              card,
              clientName,
              issuerBank,
              bankAccount,
              balance,
              cvc,
              interest,
              expirationDate
            );
            bankCards.add(creditCard);
            JOptionPane.showMessageDialog(null, "Credit Card added successfully");
            clear();
          }
        } catch (Exception ex) {
          // Handle exception for invalid input
          JOptionPane.showMessageDialog(
            null,
            "Invalid input ! Please enter a valid number."
          );
        }
      });  

      // button to clear all the components
        clearButton.addActionListener(e -> {
            clear();
        });
      //button to display credit card information from the bankcard list
        displayButton.addActionListener(e -> {
            new DisplayCreditCards(bankCards);
            


        });


        // Setting initial grid position and width 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addcreditcardLabel, gbc);



        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardidLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardidTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clientnameLabel, gbc);

        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clientnameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(issuerbankLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(issuerbankTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(bankaccountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(bankaccountTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(balanceamountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(balanceamountTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(cvcnumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(cvcnumberTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(interestrateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(interestrateTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(expirationdateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(c1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(c2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(c3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(clearButton, gbc);


        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(displayButton, gbc);

        add(panel);
    }

    private boolean isCardIdExists(ArrayList<BankCard> bankCards, String cardId) {
        for (BankCard card : bankCards) {
          if (
            card instanceof CreditCard &&
            ((CreditCard) card).getCardId() == Integer.parseInt(cardId)
          ) {
            return true;
          }
        }
        return false;
      }
     // method to clear all the components
     public void clear(){
        cardidTextField.setText("");
        clientnameTextField.setText("");
        issuerbankTextField.setText("");
        bankaccountTextField.setText("");
        balanceamountTextField.setText("");
        cvcnumberTextField.setText("");
        interestrateTextField.setText("");
        expirationdateTextField.setText("");
        c1.setSelectedIndex(0);
        c2.setSelectedIndex(0);
        c3.setSelectedIndex(0);
    }
}
