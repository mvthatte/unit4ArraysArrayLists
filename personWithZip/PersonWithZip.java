
/**
 * Write a description of class PersonWithZip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonWithZip
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private int zipCode;

    /**
     * Constructor for objects of class PersonWithZip
     */
    public PersonWithZip(String firstName, String lastName, int zipCode)
    {
       this.firstName = firstName;
       this.lastName = lastName;
       this.zipCode = zipCode;
       
    }

    public int getZip()
    {
        return zipCode;
    }
    
    public String toString()
    {
        String toString = new String("The zipcode is " + zipCode + ", and the name is " + firstName + " " + lastName);
        return toString;
    }
}
