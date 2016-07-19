import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
public class XMLToObject {

    static String XMLFileName = "person.xml";

    public static void main(String[] args) {
        try {
                JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                People people = (People) jaxbUnmarshaller.unmarshal(new File(XMLFileName));
                for (Person p : people.getPerson()) {
                    System.out.println("----------------------------");
                    System.out.println("Person id : " + p.getPersonID());
                    System.out.println("Person name : " + p.getName().getFirstName() + p.getName().getLastName() );
                    System.out.println("Person address : " + p.getAddress());
                    System.out.println("Person email : " + p.getEmail());
                    System.out.println("Person bdate : " + p.getBirthday().getBirthDay() + " : " + p.getBirthday().getBirthMonth() + " : " + p.getBirthday().getBirthYear() );
                }
            } catch (JAXBException e1) {
            e1.printStackTrace();
        }
    }
}
