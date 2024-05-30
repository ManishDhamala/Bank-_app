package coursework2.components;

import javax.swing.*;

public class CustomButton extends JButton {
    //constructor for the CustomButton class with a string parameter
    public CustomButton(String text){
        //set properties of the button
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setFont(new java.awt.Font("Arial", 0, 15));
        setForeground(new java.awt.Color(0, 0, 0));
        setBackground(new java.awt.Color(255, 255, 255));
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}
