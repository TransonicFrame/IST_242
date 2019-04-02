package Model;

public class Height {

    //-------------Attributes---------------
    private int feet;
    private int inches;

    //-----------Constructor----------------
    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    //----------Default Constructor---------
    public Height() {
        this(0, 0);
    }

    //!---------String Overrride----------
    @Override
    public String toString() {
        return getFeet() + "'" + getInches() + "\"";
    }

    //--------Getters and Setters---------
    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }
}
