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
  private Model model;
  private View view;

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
        
    }

    private void addScrolling()
    {
        getView().getIF().getIp().getCP().addMouseWheelListener(
                new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) 
            {
                int units = mwe.getUnitsToScroll();
                getModel().getFpData().setFirstLineToDisplay(getModel().getFpData().getFirstLineToDisplay() + units);
                
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
                    
                    getView().CenterUpdate(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders());
                }
            }
        });
    }
    
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
                    getView().getIF().getIp().getWP().getRadioArray().get(selection).setBackground(Color.DARK_GRAY);
                    getModel().getFpData().SetSortType(selection);
                    
                    for (int i=0; i<getView().getIF().getIp().getWP().getRadioArray().size(); i++)
                    {
                        if (i!=selection)
                        {
                            getView().getIF().getIp().getWP().getRadioArray().get(i).setSelected(false);
                            getView().getIF().getIp().getWP().getRadioArray().get(i).setBackground(Color.LIGHT_GRAY);
                        }
                    }
                }
            });
        }
    }
    
    private void setUpHeaderListener()
    {
        for (int i = 0; i<getView().getIF().getIp().getCP().getLabelArray().size(); i++){
            JLabel b = getView().getIF().getIp().getCP().getLabelArray().get(i);
            b.addMouseListener(this);
        }
    }
    
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

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        JLabel a = (JLabel) e.getSource();
        for (int i = 0; i<getView().getIF().getIp().getCP().getLabelArray().size(); i++){
            JLabel b = getView().getIF().getIp().getCP().getLabelArray().get(i);
            b.setBackground(Color.gray);
            b.setForeground(Color.white);
        }
        a.setBackground(Color.DARK_GRAY);
        getModel().getFpData().SetSortField(getView().getIF().getIp().getCP().getLabelArray().indexOf(e.getSource()));
        getModel().getFpData().sort(getModel().getFpData().getSortType(), getModel().getFpData().getSortField());
        getView().CenterUpdate(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders());
        
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
}
