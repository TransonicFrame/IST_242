package Model;

public class FootballPlayer {
//------------Attributes-----------------------------

    private int number;
    private String name;
    private String position;
    private Height height;
    private int weight;
    private String hometown;
    private String state;
    private String highSchool;

//--------------Constructor-----------------------------
    public FootballPlayer(int number, String name, String position, Height height, int weight, String hometown, String state, String highSchool) {
        this.number = number;
        this.name = name;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.hometown = hometown;
        this.state = state;
        this.highSchool = highSchool;
    }

//----------------Getters and Setters--------------------
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
