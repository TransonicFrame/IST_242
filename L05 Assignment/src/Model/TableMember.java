package Model;

import java.util.ArrayList;

public interface TableMember
{

    public String getAttribute(int n);

    public ArrayList<String> getAttributes();

    public String getAttributeName(int n);

    public ArrayList<String> getAttributeNames();
}
