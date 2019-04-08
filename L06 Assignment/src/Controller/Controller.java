package Controller;

import Model.Model;
import View.View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Controller implements MouseListener
{
    
    //--------------------------Attributes--------------------------------------
    
    private Model model;
    private View view;

    //-------------------------Constructor--------------------------------------
    
    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        
        getModel().getFpData().populateArray();
        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());
        model.getFpData().setFirstLineToDisplay(0);
        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        addScrolling();
        setUpHeaderListener();
        setUpRadioListener();
        setUpTextFieldListener(); 
    }

    //-------------------------------------------------------------Scrolling Listener------------------------------------------------------------
    
    private void addScrolling()
    {
        getView().getIF().getIp().getCP().addMouseWheelListener(
                new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) 
            {
                int units = mwe.getUnitsToScroll();
                getModel().getFpData().setFirstLineToDisplay(getModel().getFpData().getFirstLineToDisplay() + units);
                
                for (int i=0; i<getView().getIF().getIp().getCP().getButtonArray().size(); i++){
                    getView().getIF().getIp().getCP().getButtonArray().get(i).setBackground(Color.blue);
                }
                
                for (int i = 0; i <= getModel().getFpData().getPlayers().size(); i++)
                {
                   
                    if (getModel().getFpData().getLastLineToDisplay()>=getModel().getFpData().getPlayers().size())
                    {
                        getModel().getFpData().setFirstLineToDisplay(getModel().getFpData().getPlayers().size() - getModel().getFpData().getNumberOfLines());
                    }
                    else if (getModel().getFpData().getFirstLineToDisplay()<0)
                    {
                        getModel().getFpData().setFirstLineToDisplay(0);
                    }
                    
                    if (getModel().getFpData().getFirstLine()==0){
                        setRed();
                    }
                    
                    getView().CenterUpdate(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders());
                }
            }
        });
    }
    
    //-------------------------------------------------------Radio Listener------------------------------------------------
    
    private void setUpRadioListener()
    {
        for (int i = 0; i<getView().getIF().getIp().getWP().getRadioArray().size(); i++)
        {
            JRadioButton jrb = getView().getIF().getIp().getWP().getRadioArray().get(i);
            jrb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    int selection = getView().getIF().getIp().getWP().getRadioArray().indexOf(e.getSource());
                    getModel().getFpData().SetSortType(selection);
                    getView().getIF().getIp().getWP().getRadioArray().get(selection).setBackground(Color.darkGray);
                    getModel().getFpData().SetSortType(selection);
                    
                    for (int i=0; i<getView().getIF().getIp().getWP().getRadioArray().size(); i++)
                    {
                        if (i!=selection)
                        {
                            getView().getIF().getIp().getWP().getRadioArray().get(i).setSelected(false);
                            getView().getIF().getIp().getWP().getRadioArray().get(i).setBackground(Color.gray);
                        }
                    }
                }
            });
        }
    }
    
    //---------------------------------------------------Header Listener------------------------------------
    
    private void setUpHeaderListener()
    {
        for (int i = 0; i<getView().getIF().getIp().getCP().getLabelArray().size(); i++){
            JLabel b = getView().getIF().getIp().getCP().getLabelArray().get(i);
            b.addMouseListener(this);
        }
    }
    
    //-------------------------------------------------------------Mouse Listener-----------------------------------------------------------------
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        JLabel a = (JLabel) e.getSource();
        for (int i=0; i<getView().getIF().getIp().getCP().getButtonArray().size(); i++){
            getView().getIF().getIp().getCP().getButtonArray().get(i).setBackground(Color.blue);
        }
        for (int i = 0; i<getView().getIF().getIp().getCP().getLabelArray().size(); i++){
            JLabel b = getView().getIF().getIp().getCP().getLabelArray().get(i);
            b.setBackground(Color.gray);
            b.setForeground(Color.white);
        }
        a.setBackground(Color.DARK_GRAY);
        getModel().getFpData().SetSortField(getView().getIF().getIp().getCP().getLabelArray().indexOf(e.getSource()));
        getModel().getFpData().setSearchByField(getView().getIF().getIp().getCP().getLabelArray().indexOf(e.getSource()));
        getModel().getFpData().sort(getModel().getFpData().getSortType(), getModel().getFpData().getSortField());
        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        
        getView().getIF().getIp().getCP().validate();
        getView().getIF().getIp().getCP().repaint();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {}
    
    //--------------------------------------------------Text Field Listener--------------------------------------------------------------
    
    public void setUpTextFieldListener()
    {
        getView().getIF().getIp().getNP().getJtf().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (getModel().getFpData().search(getView().getIF().getIp().getNP().getJtf().getText())){
                        setRed();
                        getModel().getFpData().setFirstLine(0);
                        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
                    }
                    else {
                        getView().getIF().getIp().getNP().getJtf().setBackground(Color.red);
                    }
                } catch (Exception a) {
                    System.out.println(a.getMessage());
                    System.out.println("Must select a header & sort type!");
                }
            }
        });
    }
    
    //--------------------------------Method to set buttons red--------------------------------------
    
    public void setRed(){
        for (int i=0; i<getView().getIF().getIp().getCP().getButtonArray().size(); i++){
             getView().getIF().getIp().getCP().getButtonArray().get(i).setBackground(Color.blue);
        }
        
        int numberOfButtons = getModel().getFpData().getLineCounter() * 8;
        
        getView().getIF().getIp().getNP().getJtf().setBackground(Color.white);
        
        if (numberOfButtons<getModel().getFpData().getNumberOfLines()*8){
            for (int i=0; i<numberOfButtons; i++){
                getView().getIF().getIp().getCP().getButtonArray().get(i).setBackground(Color.red);
            }
        }
        else if (numberOfButtons>getModel().getFpData().getNumberOfLines()*8){
            for (int i=0; i<getModel().getFpData().getNumberOfLines()*8; i++){
                getView().getIF().getIp().getCP().getButtonArray().get(i).setBackground(Color.red);
            }
        }
        
    }
    
    //-------------------------------Getters/Setters----------------------------------------
    
    public Model getModel() 
    {
        return model;
    }

    public void setModel(Model model) 
    {
        this.model = model;
    }

    public View getView()
    {
        return view;
    }

    public void setView(View view) 
    {
        this.view = view;
    }
}
