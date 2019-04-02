package Model;

public class MailAddress
{
    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;

    public MailAddress(String inf_streetAddress, String inf_city, String inf_state, int inf_zipcode)
    {
        streetAddress = inf_streetAddress;
        city = inf_city;
        state = inf_state;
        zipcode = inf_zipcode;
    }

    @Override
    public String toString()
    {
        return getStreetAddress() + "," + getCity() + "," + getState() + "," + getZipcode();
    }

    public String getStreetAddress()
    {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getZipcode()
    {
        return zipcode;
    }
    
    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }
}
