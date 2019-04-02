package Model;
//edit this

import java.util.ArrayList;

public class FootballPlayer extends Person implements TableMember{

    //---------------------Attributes-------------------
    private int number;
    private String position;

    //---------------------------------------------------Constuctor including super class extending person class-----------------------------------------------------
    public FootballPlayer(int number, String i_name, String position, Height i_height, int i_weight, String i_hometown, String i_state, String i_highSchool) {
        super(i_name, i_height, i_weight, i_hometown, i_state, i_highSchool);
        this.number = number;
        this.position = position;
    }

    //-------------------------------------------------Default Constructor------------------------------------------------------------------------------------------
    public FootballPlayer() {
        this(0, "unknown", "unknown", new Height(0, 0), 0, "unknown", "unknown", "unknown");
    }

    //!---------String Override---------------!
    @Override
    public String toString() {
        return super.toString() + " #" + getNumber() + " " + getPosition();
    }
    
    //----------------------------------------Table Memeber Implementation-------------------------------------------------
    @Override
    public String getAttribute(int n) {
        return getAttributes().get(n);
    }
    
    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> attributeList = new ArrayList<>();
        attributeList.add(Integer.toString(getNumber()));
        attributeList.add(super.name);
        attributeList.add(getPosition());
        attributeList.add(Integer.toString(super.height.getFeet()) +"'" +Integer.toString(super.height.getInches()) +"\"");
        attributeList.add(Integer.toString(weight));
        attributeList.add(super.hometown);
        attributeList.add(super.state);
        attributeList.add(super.highSchool);
        return attributeList;
    }

    @Override
    public String getAttributeName(int n) {
        return getAttributeNames().get(n);
    }

    @Override
    public ArrayList<String> getAttributeNames() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("number");
        nameList.add("name");
        nameList.add("position");
        nameList.add("height");
        nameList.add("weight");
        nameList.add("hometown");
        nameList.add("state");
        nameList.add("highschool");
        return nameList;
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
