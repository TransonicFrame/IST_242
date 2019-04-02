public class app 
{
    public static void main(String[] args) 
    {
        //Incoming data
        //Second student calls constructor
        //1 2 3 4 operation 
            //1 - new
            //2 - parameter list (incoming data)
            //3 - Attributes in separte class
            //4 - Constructor to initialize parameters in class
        
        //Consturctor with no parameters - parameters mentioned in consturctor
        student st = new student();
        
        //Creates new mail address
        //mailAddress m = mailAddress(100, "College Av.", 16801, "PA"));
        
        //Constructor with parameters
        //student st1 = new student("Austin", "Cybersecurity", 18, 71833, m);
        
        //Cleaner code with address inside student
        student st1 = new student("Austin", "Cybersecurity", 18, 71833, new mailAddress(100, "College Av.", 16801, "PA"));
        
        //Calls method to display info
        st.displayInfo();
        st1.displayInfo();
    }
}
