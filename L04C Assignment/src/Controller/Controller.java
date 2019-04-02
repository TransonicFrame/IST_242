package Controller;

import Model.Model;
import View.View;

public class Controller
{
  private Model model;
  private View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        
        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());
        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
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
