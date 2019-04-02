package View;

import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel 
{
    private CenterPanel CP;
    
    public InitialPanel()
    {
       BorderLayout borderLayout = new BorderLayout(1, 1);
       setLayout(borderLayout);
       JLabel title = new JLabel();
       title.setText("PSU Football Roster");
       title.setOpaque(true);
       title.setBackground(Color.DARK_GRAY);
       title.setForeground(Color.white);
       title.setHorizontalAlignment(JLabel.CENTER);
       title.setVerticalAlignment(JLabel.CENTER);
       title.setFont(title.getFont().deriveFont(35.0f));
       add(title, BorderLayout.PAGE_START);
       CP = new CenterPanel();
       add(CP, BorderLayout.CENTER);
//------------------------------------------------------------
       setSize(getMaximumSize());
       setBackground(Color.WHITE);
    }
    public CenterPanel getCP() {
        return CP;
    }
    
    public void setCP(CenterPanel CP) {
        this.CP = CP;
    }
    
}
