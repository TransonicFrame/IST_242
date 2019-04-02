package Controller;

import Model.Model;
import View.View;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Controller
{
  private Model model;
  private View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        
        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());
        model.getFpData().setFirstLineToDisplay(0);
        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        addScrolling();
    }

    private void addScrolling()
    {
        getView().getIF().getIp().getCP().addMouseWheelListener(
                new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) {
                int units = mwe.getUnitsToScroll();
                
                getModel().getFpData().setFirstLineToDisplay(getModel().getFpData().getFirstLineToDisplay() + units);
                
                for (int i = 0; i <= getModel().getFpData().getPlayers().size(); i++){
                   
                    if (getModel().getFpData().getLastLineToDisplay()>=getModel().getFpData().getPlayers().size()){
                        getModel().getFpData().setFirstLineToDisplay(getModel().getFpData().getPlayers().size() - getModel().getFpData().getNumberOfLines());
                    }
                    else if (getModel().getFpData().getFirstLineToDisplay()<0){
                        getModel().getFpData().setFirstLineToDisplay(0);
                    }
                    
                    getView().CenterUpdate(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders());
                }
            }
        });
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
