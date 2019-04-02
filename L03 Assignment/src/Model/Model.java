package Model;

public class Model {
    
 public Model() {
        FootballPlayer fp = new FootballPlayer(2, "Marcus Allen", "S", new Height(6, 2), 209, "Upper Marlboro", "MD", "Dr. Henry A. Wise Jr.");
        System.out.println(fp.getAttributes().toString());
        System.out.println(fp.getAttributes().toString());
        
        for (int i = 0; i < fp.getAttributes().size(); i++){
            System.out.println(i + " = " + fp.getAttributeName(i) + " - " + fp.getAttribute(i));
        }
        
        System.out.println(fp.getAttributeNames().toString());
        System.out.println(fp.getAttributeNames().toString()); 
    }
}