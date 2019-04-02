package View;

public class View
{

    private MainFrame mf;

    public View()
    {
        mf = new MainFrame();
    }
    
    public void displayInButton(String output, int number) 
    {
        getMf().getIp().setText(output, number);
    }
    
    public MainFrame getMf()
    {
        return mf;
    }
    
    public void setMf(MainFrame mf)
    {
        this.mf = mf;
    }
}
