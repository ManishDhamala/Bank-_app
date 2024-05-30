package coursework2.components;
import javax.swing.*;

public class CustomLabel extends JLabel{
//constructor for the CustomLabel class with a string parameter
    public CustomLabel(String text){
        //set properties of the label
        super(text);
        setFont(new java.awt.Font("Arial", 0, 15));
    }
    
}
