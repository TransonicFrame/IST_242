public class app {

    public static void main(String[] args) {
       //String is a class, but most importantly it is a object
       player p1 = new player("Fred Fonz", "Belo", 457748547, 33, "Soccer", "Forward");
       player p2 = new player("Ronaldinho", "Porto", 574574, 10, "Soccer", "Midfield");
       
       System.out.println("");
       
       p1.displayInfo();
       p2.displayInfo();
    }
}
