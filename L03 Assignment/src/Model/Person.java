package Model;

public class Person {

    //----------------------------Attributes---------------------------------
    protected String name;
    protected Height height;
    protected int weight;
    protected String hometown;
    protected String state;
    protected String highSchool;

    //------------------------------------------------------------------Constructor------------------------------------------------------------------------
    public Person(String name, Height height, int weight, String hometown, String state, String highSchool) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hometown = hometown;
        this.state = state;
        this.highSchool = highSchool;
    }

    //------------------------------------------------------------------Default Constructor---------------------------------------------------------------
    public Person() {
        this("unknown", new Height(0, 0), 0, "unknown", "unknown", "unknown");
    }

    //!-------------------String Override---------------!
    @Override
    public String toString() {
        return getName() + " " + getHeight().toString() + " " + getWeight() + " lbs " + getHometown() + "," + getState() + " " + getHighSchool();
    }

    //-------------------Getters and Setters---------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }
}
