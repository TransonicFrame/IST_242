package Model;

public class Student
{
    //---------Declaring attributes----

    private String firstName;
    private String lastName;
    private int age;
    private MailAddress address;
    private int credits;
    //------------------------------
    //----------Constructor------------

    public Student(String a, String b, int c, MailAddress d)
    {
        firstName = a;
        lastName = b;
        age = c;
        address = d;
        credits = creditsThisSemester();
    }

    //---------- METHODS --------
    public String getInfo()
    {
        return "NAME = " + getFirstName() + "  " + getLastName() + "  " + "Age = " + getAge() + ", address=" + getAddress().toString() + " credits=" + getCredits();
    }

    //------------------------------------------------
    public int creditsThisSemester()
    {
        //calculate randomly a new value for credits in the semester
        //and updates the attribute credits
        double dn = Math.random();
        setCredits((int) (15.0 * dn));
        return getCredits();
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public MailAddress getAddress()
    {
        return address;
    }

    public void setAddress(MailAddress address)
    {
        this.address = address;
    }

    public int getCredits()
    {
        return credits;
    }

    public void setCredits(int credits)
    {
        this.credits = credits;
    }
}
