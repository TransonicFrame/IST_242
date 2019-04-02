package Model;

public class Model {
//-----------Attributes----------------

    private int heightPlyr1;
    private int heightPlyr2;
    private int heightPlyr3;

//---------------------------------------------------------------------------------------------Initialize new players---------------------------------------------------------------------------------------------------
    private FootballPlayer footballPlayer1 = new FootballPlayer(24, "Miles Sanders", "Running Back", new Height(5, 11), 215, "Pittsburgh", "PA", "Woodland Hills School District");
    private FootballPlayer footballPlayer2 = new FootballPlayer(4, "Ricky Slade", "Running Back", new Height(5, 9), 198, "Woodbridge", "VA", "C. D. Hylton");
    private FootballPlayer footballPlayer3 = new FootballPlayer(1, "KJ Hamler", "Wide Reciever", new Height(5, 9), 173, "Pontiac", "MI", "IMG Academy");

    //-------------------------------------------Code to test for multiple players having the same height------------------------------------------------------------------------------------------------- 
    //private FootballPlayer footballPlayer3 = new FootballPlayer(3, "DeAndre Thompkins", "Wide Reciever", new Height(5, 11), 188, "Hubert", "NC", "Swansboro");
    //---------------------------------------------Code to test for all players being the same height-----------------------------------------------------------------------------------------------------
    //private FootballPlayer footballPlayer1 = new FootballPlayer(10, "Brandon Polk", "Wide Reciever", new Height(5, 9), 179, "Ashburn", "VA", "Briar Woods. H.S.");
    
//------------------------------Get height and convert to all inches--------------------------------------
    void getHeight() {
        //Calculation belongs in height .ok.
        //Gets the height of the player in feet
        setHeightPlyr1(getFootballPlayer1().getHeight().getFeet());
        setHeightPlyr2(getFootballPlayer2().getHeight().getFeet());
        setHeightPlyr3(getFootballPlayer3().getHeight().getFeet());

        //Converts the height of the player in feet to inches
        setHeightPlyr1(getHeightPlyr1() * 12);
        setHeightPlyr2(getHeightPlyr2() * 12);
        setHeightPlyr3(getHeightPlyr3() * 12);

        //Adds the height of the player in inches to the current height in inches
        setHeightPlyr1(getHeightPlyr1() + getFootballPlayer1().getHeight().getInches());
        setHeightPlyr2(getHeightPlyr2() + getFootballPlayer2().getHeight().getInches());
        setHeightPlyr3(getHeightPlyr3() + getFootballPlayer3().getHeight().getInches());
    }

//----------------------------------------Compares heights-----------------------------------------------------------
    public void compareHeights() {
        //Gets the height of all players inches
        getHeight();

        //Compares heights of all players specfing who is the tallest
        if (getHeightPlyr1() < getHeightPlyr2() && getHeightPlyr2() > getHeightPlyr3()) {
            displayTallestSingle(getFootballPlayer2());
        } else if (getHeightPlyr3() < getHeightPlyr2() && getHeightPlyr2() > getHeightPlyr1()) {
            displayTallestSingle(getFootballPlayer2());
        } else if (getHeightPlyr2() < getHeightPlyr1() && getHeightPlyr1() > getHeightPlyr3()) {
            displayTallestSingle(getFootballPlayer1());
        } else if (getHeightPlyr3() < getHeightPlyr1() && getHeightPlyr1() > getHeightPlyr2()) {
            displayTallestSingle(getFootballPlayer1());
        } else if (getHeightPlyr2() < getHeightPlyr3() && getHeightPlyr3() > getHeightPlyr1()) {
            displayTallestSingle(getFootballPlayer3());
        } else if (getHeightPlyr1() < getHeightPlyr3() && getHeightPlyr3() > getHeightPlyr2()) {
            displayTallestSingle(getFootballPlayer3());
        } else if (getHeightPlyr1() == getHeightPlyr2() && getHeightPlyr2() > getHeightPlyr3()) {
            displayTallestTwo(getFootballPlayer1(), getFootballPlayer2());
        } else if (getHeightPlyr1() == getHeightPlyr3() && getHeightPlyr3() > getHeightPlyr2()) {
            displayTallestTwo(getFootballPlayer1(), getFootballPlayer3());
        } else if (getHeightPlyr3() == getHeightPlyr2() && getHeightPlyr2() > getHeightPlyr1()) {
            displayTallestTwo(getFootballPlayer3(), getFootballPlayer2());
        } else if (getHeightPlyr1() == getHeightPlyr3() && getHeightPlyr3() == getHeightPlyr2()) {
            System.out.println(getFootballPlayer1().getName() + ", " + getFootballPlayer2().getName() + ", and " + getFootballPlayer3().getName() + " are the tallest players at a height of " + getFootballPlayer1().getHeight().getFeet() + "'" + getFootballPlayer1().getHeight().getInches() + "\"!");
        }
    }

//-----------------------------------------------------------------------------------------------Display tallest player with their height-----------------------------------------------------------
    void displayTallestSingle(FootballPlayer tallestPlayer) {
        System.out.println(tallestPlayer.getName() + " is the tallest player at the height of " + tallestPlayer.getHeight().getFeet() + "'" + tallestPlayer.getHeight().getInches() + "\"!");
    }

//-----------------------------------------------------------------------------------------------Display tallest players(multiple) and their height-----------------------------------------------------------------------------------
    void displayTallestTwo(FootballPlayer tallestPlayer1, FootballPlayer tallestplayer2) {
        System.out.println(tallestPlayer1.getName() + " and " + tallestplayer2.getName() + " are the tallest players at a height of " + tallestPlayer1.getHeight().getFeet() + "'" + tallestPlayer1.getHeight().getInches() + "\"!");
    }

//--------------------------Getters and Setters----------------------------
    public int getHeightPlyr1() {
        return heightPlyr1;
    }

    public void setHeightPlyr1(int heightPlyr1) {
        this.heightPlyr1 = heightPlyr1;
    }

    public int getHeightPlyr2() {
        return heightPlyr2;
    }

    public void setHeightPlyr2(int heightPlyr2) {
        this.heightPlyr2 = heightPlyr2;
    }

    public int getHeightPlyr3() {
        return heightPlyr3;
    }

    public void setHeightPlyr3(int heightPlyr3) {
        this.heightPlyr3 = heightPlyr3;
    }

    public FootballPlayer getFootballPlayer1() {
        return footballPlayer1;
    }

    public void setFootballPlayer1(FootballPlayer footballPlayer1) {
        this.footballPlayer1 = footballPlayer1;
    }

    public FootballPlayer getFootballPlayer2() {
        return footballPlayer2;
    }

    public void setFootballPlayer2(FootballPlayer footballPlayer2) {
        this.footballPlayer2 = footballPlayer2;
    }

    public FootballPlayer getFootballPlayer3() {
        return footballPlayer3;
    }

    void setFootballPlayer3(FootballPlayer footballPlayer3) {
        this.footballPlayer3 = footballPlayer3;
    }
}
