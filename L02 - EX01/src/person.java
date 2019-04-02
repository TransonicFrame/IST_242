public class person {
    String name;
    String hometown;
    int ssn;
    
    public person (String a, String b, int c){
        name = a;
        hometown = b;
        ssn = c;
    }
    
    String getInfo(){
        return name +" " +hometown +" " +ssn;
    }
}
