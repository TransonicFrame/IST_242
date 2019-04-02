package Model;

public class Height {
//-------------Attributes------------------

    private int feet;
    private int inches;

//------------Constructor------------------
    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

//-----------Getter and Setters------------
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
