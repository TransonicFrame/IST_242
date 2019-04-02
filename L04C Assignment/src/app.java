import Controller.Controller;
import Model.Model;
import View.View;


public class app
{
    public static void main(String[] args)
    {
       View view = new View();
       Model model = new Model();
       Controller controller = new Controller(model, view);
    }
}