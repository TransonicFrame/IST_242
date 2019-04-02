package Model;

import java.util.ArrayList;

public class Model
{
    private ArrayList<Student> sts = new ArrayList<>();

    public Model()
    {
        //creates 3 students
        MailAddress addr1 = new MailAddress("107 W College Avenue", "State College", "PA", 16801);
        Student st1 = new Student("Emily", "Smith", 20, addr1);
        MailAddress addr2 = new MailAddress("200 W College Avenue", "State College", "PA", 16801);
        Student st2 = new Student("Mary", "Doe", 20, addr2);
        MailAddress addr3 = new MailAddress("300 W College Avenue", "State College", "PA", 16801);
        Student st3 = new Student("John", "Doe", 20, addr3);
        //add them to the array of students
        sts.add(st1);
        sts.add(st2);
        sts.add(st3);
    }

    public String findStudent(int student){
        return getSts().get(student).getInfo();
    }
    
    public ArrayList<Student> getSts()
    {
        return sts;
    }

    public void setSts(ArrayList<Student> sts)
    {
        this.sts = sts;
    }
}
