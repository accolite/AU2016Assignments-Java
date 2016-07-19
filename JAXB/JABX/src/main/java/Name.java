import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
public class Name {
    private String firstName;
    private String lastName;

    public Name(){
    }

    public Name(String first,String last){
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
