
	import java.io.File;
	import javax.xml.bind.JAXBContext;
	import javax.xml.bind.JAXBException;
	import javax.xml.bind.Unmarshaller;
public class Unmarshalling_file {

	public Unmarshalling_file() {
		// TODO Auto-generated constructor stub
	}
		public static void main(String[] args) {

		 try {

			File file = new File("D:\\newfil1e.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Students student11 = (Students)jaxbUnmarshaller.unmarshal(file);
			System.out.println("students");
			for(StudentRecords std:student11.getStudents())
			{
			System.out.println(std.getEmail());
			System.out.println(std.getFirstname());
			System.out.println(std.getLastname());
			System.out.println(std.getPhonenumber());
			}
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}
	}

