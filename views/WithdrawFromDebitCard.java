package coursework2.views;

import coursework2.BankCard;
import coursework2.DebitCard;

import coursework2.components.CustomButton;
import coursework2.components.CustomLabel;
import coursework2.components.CustomTextField;
import coursework2.components.CustomComboBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WithdrawFromDebitCard extends JFrame {
    //Declare CustomTextField,CustomComboBox,CustomLabel and CustomButton variables
    CustomButton withdrawButton, clearButton;
    CustomTextField card_id_TextField, withdrawal_amount_TextField, date_of_withdrawal_TextField, pin_TextField;
    CustomLabel withdraw_from_debit_card_Label, card_id_Label, withdrawal_amount_Label, date_of_withdrawal_Label, pin_Label;
    CustomComboBox c1,c2,c3;
   // WithdrawFromDebitCard constructor with ArrayList<BankCard> parameter to store bank cards
    public WithdrawFromDebitCard(ArrayList<BankCard> bankCards){
        super("Withdraw from Debit Card");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        //LAbel
        withdraw_from_debit_card_Label = new CustomLabel("Withdraw from Debit Card");
        card_id_Label = new CustomLabel("Card Id");
        withdrawal_amount_Label = new CustomLabel("Withdrawal Amount");
        date_of_withdrawal_Label = new CustomLabel("Date of Withdrawal");
        pin_Label = new CustomLabel("PIN");
        
        //Text field

        card_id_TextField = new CustomTextField("");
        withdrawal_amount_TextField = new CustomTextField("");
        date_of_withdrawal_TextField = new CustomTextField("");
        pin_TextField = new CustomTextField("");

        //Button
        withdrawButton = new CustomButton("Withdraw");
        clearButton = new CustomButton("Clear");

        //combo box for years
        c1 = new CustomComboBox(new String[]{
            "select year", "2016", "2017", "2018", "2019",
            "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"});
        // combo box for months
         c2 = new CustomComboBox(new String[]{
            "select month",
            "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October","November","December"});
         //combo box for days
         c3 = new CustomComboBox(new String[]{"select day",
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20",
        "21","22","23","24","25","26","27","28","29","30","31"});

          //button to withdraw from debitcard
        withdrawButton.addActionListener(e -> {
            //get the values from the text fields
            String cardId = card_id_TextField.getText();
            String withdrawalAmount = withdrawal_amount_TextField.getText();
            String dateOfWithdrawal = c1.getSelectedItem() + " " + c2.getSelectedItem() + " " + c3.getSelectedItem();
            String pin = pin_TextField.getText();
      
            if (
              cardId.equals("") ||
              withdrawalAmount.equals("") ||
              dateOfWithdrawal.equals("") ||
              c1.getSelectedIndex() == 0 ||
              c2.getSelectedIndex() == 0 ||
              c3.getSelectedIndex() == 0 ||
              pin.equals("") 

            ) {
              JOptionPane.showMessageDialog(null, "Please fill all the fields");
            }
            else if (
              !cardId.matches("[0-9]+") ||
              !withdrawalAmount.matches("[0-9]+") ||
              !pin.matches("[0-9]+") 
            ) {
              JOptionPane.showMessageDialog(null, "Please enter a valid input");
            } else {
              try {
                //extract the contents from the text fields, transform them to the correct type, and display a message
                int card = Integer.parseInt(cardId);
                int withdrawal = Integer.parseInt(withdrawalAmount);
                int pinNumber = Integer.parseInt(pin);
                boolean foundCard = false;
                DebitCard debitCard = null;
                for (BankCard bankCard : bankCards) {
                  if (bankCard instanceof DebitCard) {  
                    debitCard = (DebitCard) bankCard;
                    //check if the card id match
                    if (debitCard.getCardId() == card) {
                      foundCard = true;
                      break;
                    }
                  }
                }
      
                if (foundCard) { 
                  withdraw(debitCard,withdrawal,dateOfWithdrawal ,pinNumber );
                } else {
                  JOptionPane.showMessageDialog(null, "Card not found");
                }
              } catch (Exception exp) {
                JOptionPane.showMessageDialog(null, "Please enter a valid input");
              }
            }
          });


          //Button to clear all the components
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
        panel.add(withdraw_from_debit_card_Label, gbc);

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
        panel.add(withdrawal_amount_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(withdrawal_amount_TextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(date_of_withdrawal_Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(c1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(c2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(c3, gbc);


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
        gbc.gridwidth = 1;
        panel.add(withdrawButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(clearButton, gbc);



        add(panel);
    }

    public void withdraw(
        DebitCard debitCard,
        int withdrawal,
        String dateOfWithdrawal,
        int pinNumber
        
      ) {
        //check if the pin number match or not
        if (debitCard.getPin() == pinNumber) {
          //check if the balance is sufficient for the withdraw
          if (debitCard.getBalanceAmount() < withdrawal) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
          }
          //calling the withdraw method
          debitCard.withdraw(withdrawal,dateOfWithdrawal, pinNumber);
          JOptionPane.showMessageDialog(null, "Successfully withdraw");
          clear();
        } else {
          JOptionPane.showMessageDialog(null, "Incorrect PIN");
        }
      }


     // method to clear all the components
    public void clear(){
        card_id_TextField.setText("");
        withdrawal_amount_TextField.setText("");
        date_of_withdrawal_TextField.setText("");
        pin_TextField.setText("");
        c1.setSelectedIndex(0);
        c2.setSelectedIndex(0);
        c3.setSelectedIndex(0);
    }

}
