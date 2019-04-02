package View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class InitialPanel extends JPanel
{
    private ArrayList<JButton> buttonArray = new ArrayList<>();
    
    public InitialPanel()
    {
        super();
        GridLayout g1 = new GridLayout(3, 1);
        this.setLayout(g1);
        setBackground(Color.WHITE);
        
        JButton b1 = new JButton();
        b1.setFont(b1.getFont().deriveFont(20.0f));
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        JButton b2 = new JButton();
        b2.setFont(b2.getFont().deriveFont(20.0f));
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        JButton b3 = new JButton();
        b3.setFont(b3.getFont().deriveFont(20.0f));
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        
        buttonArray.add(b1);
        add(b1);
        buttonArray.add(b2);
        add(b2);
        buttonArray.add(b3);
        add(b3);
    }
    
    public void setText(String text, int number)
    {
        getButtonArray().get(number).setText(text);
    }

    public ArrayList<JButton> getButtonArray() 
    {
        return buttonArray;
    }

    public void setButtonArray(ArrayList<JButton> buttonArray) 
    {
        this.buttonArray = buttonArray;
    }
}
