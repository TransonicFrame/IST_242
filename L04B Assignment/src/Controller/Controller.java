package Controller;

import Model.Model;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller 
{
    private Model model;
    private View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
       
        int n1 = 0;
        view.displayInButton(model.findStudent(n1), n1);
        int n2 = 1;
        view.displayInButton(model.findStudent(n2), n2);
        int n3 = 2;
        view.displayInButton(model.findStudent(n3), n3);
        
        view.getMf().getIp().getButtonArray().get(n1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getSts().get(n1).creditsThisSemester();
                view.displayInButton(model.findStudent(n1), n1);
            }
        });
        view.getMf().getIp().getButtonArray().get(n2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getSts().get(n2).creditsThisSemester();
                view.displayInButton(model.findStudent(n2), n2);
            }
        });
        view.getMf().getIp().getButtonArray().get(n3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getSts().get(n3).creditsThisSemester();
                view.displayInButton(model.findStudent(n3), n3);
            }
        });
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
