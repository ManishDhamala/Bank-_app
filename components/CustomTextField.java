package coursework2.components;
import javax.swing.*;

public class CustomTextField extends JTextField{
//constructor for the CustomTextField class with a string parameter
    public CustomTextField(String text){
        //set properties of the textField
        super(text);
        setColumns(10);
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }

    
}
