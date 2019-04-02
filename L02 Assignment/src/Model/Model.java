package Model;

public class Model {

    //----------------------------------------------------------------Creates three new football players-------------------------------------------------------------------------
    private FootballPlayer footballPlayer1 = new FootballPlayer("Zach Simpson", new Height(6, 3), 290, "Hollidaysburg", "PA", "Hollidaysburg Area", 64, "Center");
    private FootballPlayer footballPlayer2 = new FootballPlayer("Mike Miranda", new Height(6, 3), 298, "Stow", "OH", "Stow-Munroe", 73, "Right Guard");
    private FootballPlayer footballPlayer3 = new FootballPlayer("Will Fries", new Height(6, 6), 306, "Cranford", "NJ", "Cranford", 71, "Right Tackle");

    //--------------------------------------------------------------Creates a new offensive line using the 3 previous players----------------------------------------------------
    private OffensiveLine offensiveLine1 = new OffensiveLine(footballPlayer1, footballPlayer2, footballPlayer3);

    //-------------------------Prints out offensive line---------------------
    public void displayOlInfo() {
        System.out.println(getOffensiveLine1().toString());
    }

    //-------------------------Prints out average weight---------------------
    public void displayAvgWeight() {
        System.out.println("                                   " + getOffensiveLine1().averageWeight() + " lbs");
    }

    //-------------------------Getters and Setters--------------------------
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

    public void setFootballPlayer3(FootballPlayer footballPlayer3) {
        this.footballPlayer3 = footballPlayer3;
    }

    public OffensiveLine getOffensiveLine1() {
        return offensiveLine1;
    }

    public void setOffensiveLine1(OffensiveLine offensiveLine1) {
        this.offensiveLine1 = offensiveLine1;
    }
}
