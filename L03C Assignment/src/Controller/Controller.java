package Controller;

import Model.Model;
import View.View;

public class Controller
{
    private Model model;
    private View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        getData();
    }
    
    public void getData()
    {
        int n1 = 0;
        view.displayData(model.findStudent(n1));
        int n2 = 1;
        view.displayData(model.findStudent(n2));
        int n3 = 2;
        view.displayData(model.findStudent(n3));
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
}
