package Model;

public class OffensiveLine {

    //-------------Attributes------------
    private FootballPlayer center;
    private FootballPlayer offensiveGuard;
    private FootballPlayer offensiveTackle;

    //-------------------------------------------------------Contructor-------------------------------------------------
    public OffensiveLine(FootballPlayer center, FootballPlayer offensiveGuard, FootballPlayer offensiveTackle) {
        this.center = center;
        this.offensiveGuard = offensiveGuard;
        this.offensiveTackle = offensiveTackle;
    }

    //-----------------------------------------------Default Constructor------------------------------------------------
    public OffensiveLine() {
        this(null, null, null);
    }

    //----------------------------------------------------Finds average weight and returns-------------------------------
    int averageWeight() {
        System.out.println("                                Average Weight                  ");
        return (getCenter().getWeight() + getOffensiveGuard().getWeight() + getOffensiveTackle().getWeight()) / 3;
    }

    //-----------------String Override---------------
    @Override
    public String toString() {
        System.out.println("                                Offensive Line                  ");
        return "Offensive Center: " + getCenter().toString() + "\n" + "Offensive Guard: " + getOffensiveGuard().toString() + "\n" + "Offensive Tackle: " + getOffensiveTackle().toString() + " \n";
    }

    //-----------------Getters and Setters-----------
    public FootballPlayer getCenter() {
        return center;
    }

    public void setCenter(FootballPlayer center) {
        this.center = center;
    }

    public FootballPlayer getOffensiveGuard() {
        return offensiveGuard;
    }

    public void setOffensiveGuard(FootballPlayer offensiveGuard) {
        this.offensiveGuard = offensiveGuard;
    }

    public FootballPlayer getOffensiveTackle() {
        return offensiveTackle;
    }

    public void setOffensiveTackle(FootballPlayer offensiveTackle) {
        this.offensiveTackle = offensiveTackle;
    }
}
