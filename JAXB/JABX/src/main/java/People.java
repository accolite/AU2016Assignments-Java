import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
@XmlRootElement
public class People {
    private List<Person> person;

    public People(){
        person = new ArrayList<Person>();
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }


}
