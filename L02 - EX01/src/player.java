class player extends person {
    
    //String name
    //String hometown
    //int ssn
    int number;
    String sports;
    String position;
    
    public player(String i_name, String i_hometown, int i_ssn, int b, String c, String d){
        
        super(i_name, i_hometown, i_ssn); //Means person p1 = new person (1_nm, i_ht, i_ssn), can only be first statement
        number = b;
        sports = c;
        position = d;
        
    }
    
    @Override
    String getInfo(){
        //super.getInfo();
        String s = super.getInfo() +" " +number +" " +sports +" " +position;
        // Or use this cause player extends to person and super is enabled
        //String s = name +" " +number +" " +sports +" " +position;
        return s;
    }
    
    void displayInfo(){
        System.out.println(getInfo());
    }
}
