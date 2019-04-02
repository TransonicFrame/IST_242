class student 
{
    //Attributes
    //Use private attribute type to encapsulate
    String name;
    String major;
    int age;
    int id;
    mailAddress ma;
    
    //Constructors are public and have same name as class
    //Constuctor to initialize class
    public student(String a, String b, int c, int d, mailAddress e)
    {
        name = a;
        major = b;
        age = c;
        id = d;
        ma = e;
        
    }
    
    //Constructor with no parameters for app
    public student()
    {
        this("John", "Doe", 0, 0, new mailAddress(100, "College Av.", 16801, "PA"));
        
        //or this code
        /*name = "John Doe";
        major = "IST";
        age = 0;
        id = 0;*/
    }
    
    String getInfo()
    {
        //Can skip this part (see displayInfo())
        String s = name + " " + major + " " + age + " " + id + " " +ma.number + " " +ma.name + " " + ma.zip + " " + ma.state;
        return s;
    }
    
    void displayInfo()
    {
       System.out.println(this.name + " " + major + " " + age + " " + id + " " +ma.number + " " +ma.name + " " + ma.zip + " " + ma.state);
       //Calling getInfo() for format
       System.out.println(getInfo());
    }
}
