package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WestPanel extends JPanel
{
    private ArrayList<JRadioButton> radioArray = new ArrayList<>();
    private JButton instruction;
    
    public WestPanel()
    {
        GridLayout g1 = new GridLayout(4, 1, 2, 2);
        setLayout(g1);
        setBackground(Color.white);
        
        JLabel sortLabel = new JLabel();
        sortLabel.setText("Choose a SORT Type");
        sortLabel.setOpaque(true);
        sortLabel.setBackground(Color.darkGray);
        sortLabel.setForeground(Color.white);
        sortLabel.setHorizontalAlignment(JLabel.CENTER);
        sortLabel.setVerticalAlignment(JLabel.CENTER);
        
        JRadioButton selectionButton = new JRadioButton();
        selectionButton.setText("(1)Selection/Write Yourself");
        selectionButton.setBackground(Color.gray);
        selectionButton.setForeground(Color.white);
        radioArray.add(selectionButton);
        
        JRadioButton mergeButton = new JRadioButton();
        mergeButton.setText("(2)Merge/ArrayList");
        mergeButton.setBackground(Color.gray);
        mergeButton.setForeground(Color.white);
        radioArray.add(mergeButton);
       
        JRadioButton quickButton = new JRadioButton();
        quickButton.setText("(3)Quick/Arrays");
        quickButton.setBackground(Color.gray);
        quickButton.setForeground(Color.white);
        radioArray.add(quickButton);
        
        add(sortLabel);
        add(selectionButton);
        add(mergeButton);
        add(quickButton);
    }
    
    
    
    public ArrayList<JRadioButton> getRadioArray() {
        return radioArray;
    }

    public void setRadioArray(ArrayList<JRadioButton> radioArray) {
        this.radioArray = radioArray;
    }

    public JButton getInstruction() {
        return instruction;
    }

    public void setInstruction(JButton instruction) {
        this.instruction = instruction;
    }
}
