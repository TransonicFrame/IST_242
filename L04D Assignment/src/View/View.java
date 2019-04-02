package View;

import java.util.ArrayList;
import javax.swing.JFrame;

public class View
{

    private InitialFrame IF;

    public View()
    {
        IF = new InitialFrame();
        IF.setExtendedState(IF.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
    
    public void CenterUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        
        for (int i = 0; i < headers.size(); i++){
            getIF().getIp().getCP().getLabelArray().get(i).setText(headers.get(i).substring(0, 1).toUpperCase() + headers.get(i).substring(1));
        }
        int i = 0;
        for (int y = 0; y<=lines.size(); y++){
            getIF().getIp().getCP().getButtonArray().get(i).setText(lines.get(y).get(0));
            getIF().getIp().getCP().getButtonArray().get(i+1).setText(lines.get(y).get(1));
            getIF().getIp().getCP().getButtonArray().get(i+2).setText(lines.get(y).get(2));
            getIF().getIp().getCP().getButtonArray().get(i+3).setText(lines.get(y).get(3));
            getIF().getIp().getCP().getButtonArray().get(i+4).setText(lines.get(y).get(4));
            getIF().getIp().getCP().getButtonArray().get(i+5).setText(lines.get(y).get(5));
            getIF().getIp().getCP().getButtonArray().get(i+6).setText(lines.get(y).get(6));
            getIF().getIp().getCP().getButtonArray().get(i+7).setText(lines.get(y).get(7));
            i = i+8;
            
            if (i==getIF().getIp().getCP().getButtonArray().size()){
                break;
            }
        }
        
        getIF().getIp().getCP().validate();
        getIF().getIp().getCP().repaint();
    }

    public void CenterInitialSetup(int linesBeingDisplayed, int size) {
        getIF().getIp().getCP().createLabels(linesBeingDisplayed, size);
    }

    public InitialFrame getIF()
    {
        return IF;
    }
    
    public void setMf(InitialFrame IF)
    {
        this.setIF(IF);
    }
    
    public void setIF(InitialFrame IF) {
        this.IF = IF;
    }
}
