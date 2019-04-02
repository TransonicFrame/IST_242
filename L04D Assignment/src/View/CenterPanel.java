package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanel extends JPanel implements MouseListener
{
    protected ArrayList<JLabel> labelArray = new ArrayList<>();
    protected ArrayList<JButton> buttonArray = new ArrayList<>();    
    public CenterPanel()
    {
        setBackground(Color.white);
    }
    
    public void createLabels(int linesBeingDisplayed, int size){
        for (int i = 0; i < size; i++){
            String labelName = "l" +(i+1);
            getLabelArray().add(new JLabel(labelName));
            JLabel a = getLabelArray().get(i);
            a.setOpaque(true);
            a.setBackground(Color.GRAY);
            a.setForeground(Color.white);
            a.setFont(a.getFont().deriveFont(30.0f));
            a.setHorizontalAlignment(JLabel.CENTER);
            a.setVerticalAlignment(JLabel.CENTER);
            add(a);
            a.addMouseListener(this);
        }
        
        createButtons(linesBeingDisplayed, size);
        validate();
        repaint();
    }
    
    public void createButtons(int linesBeingDisplayed, int size){
        GridLayout grid = new GridLayout(linesBeingDisplayed + 1, size, 2, 2);
        setLayout(grid);
        int buttons = linesBeingDisplayed * size;
        for (int i = 0; i < buttons; i++){
            String buttonName = "b" +(i+1);
            getButtonArray().add(new JButton(buttonName));
            JButton a = getButtonArray().get(i);
            a.setBackground(Color.BLUE);
            a.setForeground(Color.white);
            a.setFont(a.getFont().deriveFont(25.0f));
            add(a);
        }
    }
    
    
    public ArrayList<JLabel> getLabelArray() {
        return labelArray;
    }

    public void setLabelArray(ArrayList<JLabel> labelArray) {
        this.labelArray = labelArray;
    }

    public ArrayList<JButton> getButtonArray() {
        return buttonArray;
    }

    public void setButtonArray(ArrayList<JButton> buttonArray) {
        this.buttonArray = buttonArray;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel a = (JLabel) e.getSource();
        for (int i = 0; i<getLabelArray().size(); i++){
            JLabel b = getLabelArray().get(i);
            b.setBackground(Color.gray);
            b.setForeground(Color.white);
        }
        
        a.setBackground(Color.DARK_GRAY);
        
        validate();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
