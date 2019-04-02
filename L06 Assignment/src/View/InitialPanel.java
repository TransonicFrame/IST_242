package View;

import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel 
{
    private CenterPanel CP;
    private WestPanel WP;
    private NorthPanel NP;
    
    public InitialPanel()
    {
       BorderLayout borderLayout = new BorderLayout(1, 1);
       setLayout(borderLayout);
       
       CP = new CenterPanel();
       add(CP, BorderLayout.CENTER);
       WP = new WestPanel();
       add(WP, BorderLayout.WEST);
       NP = new NorthPanel();
       add(NP, BorderLayout.NORTH);
       
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

    public WestPanel getWP() {
        return WP;
    }

    public void setWP(WestPanel WP) {
        this.WP = WP;
    }
    
    public NorthPanel getNP() {
        return NP;
    }
    
    public void setNP(NorthPanel NP) {
        this.NP = NP;
    }
}
