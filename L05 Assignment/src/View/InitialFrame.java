package View;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;

public class InitialFrame extends JFrame 
{
    
    private InitialPanel ip;

    public InitialFrame()
    {
        super("L05 Assignment");
        setupLayoutForMacs();
        ip = new InitialPanel();
        add(ip, "Center");
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setupLayoutForMacs()
    {
        // On some MACs it might be necessary to have the statement below
        //for the background color of the button to appear
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public InitialPanel getIp()
    {
        return ip;
    }
    
    public void setIp(InitialPanel ip)
    {
        this.ip = ip;
    }
    
}
