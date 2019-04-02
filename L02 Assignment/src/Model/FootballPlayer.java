package Model;

public class FootballPlayer extends Person {

    //---------------------Attributes-------------------
    private int number;
    private String position;

    //---------------------------------------------------Constuctor including super class extending person class-----------------------------------------------------
    public FootballPlayer(String i_name, Height i_height, int i_weight, String i_hometown, String i_state, String i_highSchool, int number, String position) {
        super(i_name, i_height, i_weight, i_hometown, i_state, i_highSchool);
        this.number = number;
        this.position = position;
    }

    //-------------------------------------------------Default Constructor------------------------------------------------------------------------------------------
    public FootballPlayer() {
        this("unknown", new Height(0, 0), 0, "unknown", "unknown", "unknown", 0, "unknown");
    }

    //!---------String Override---------------!
    @Override
    public String toString() {
        return super.toString() + " #" + getNumber() + " " + getPosition();
    }

    //-----------------Getters and Setters-----------
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
