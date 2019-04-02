public class footballPlayer extends player{
    
    int yardsInAGame;
    
    public footballPlayer(String i_name, String i_hometown, int i_ssn, int b, String c, String d, int y){
        super(i_name, i_hometown, i_ssn, b, c, d);
        //calling the constuctor of player
        this.yardsInAGame = y;
    }
}
