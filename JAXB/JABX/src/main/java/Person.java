import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
@XmlRootElement
public class Person {

    private int personID;
    private Name name;
    private String email;
    private String address;
    private Birthday birthday;

    public Person(){
    }

    public Person(int personID,Name name,String email,String address,Birthday birthday){
        this.personID = personID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @XmlElement
    public int getPersonID() {
        return personID;
    }

    @XmlElement
    public Name getName() {
        return name;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    @XmlElement
    public Birthday getBirthday() {
        return birthday;
    }
}
