package View;

import javax.swing.*;

public class MainFrame extends JFrame
{

    private InitialPanel ip;

    public MainFrame()
    {
        super("L04 Assignment");
        setupLayoutForMacs();
        ip = new InitialPanel();
        add(ip, "Center");
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
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
