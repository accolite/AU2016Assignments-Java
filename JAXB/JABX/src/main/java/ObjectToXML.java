import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/19/2016.
 */
public class ObjectToXML {

    static String XMLFileName = "person.xml";

    public static void main(String[] args) throws Exception{

        List<Person> personList = new ArrayList<Person>();
        Person person = new Person(1,new Name("Mitul","Kapoor"),"mitul@accolite.com","asd,asd,asd",new Birthday(21,10,1992));
        Person person1 = new Person(2,new Name("QWE","RTY"),"kapoor@accolite.com","qwe,qwe,qwe",new Birthday(1,11,1994));
        personList.add(person);
        personList.add(person1);

        People people = new People();
        people.setPerson(personList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(people, new FileOutputStream(XMLFileName));
            System.out.println("File created and content written.");
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
