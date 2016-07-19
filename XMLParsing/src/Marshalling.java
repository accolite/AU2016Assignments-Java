import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshalling {

	public Marshalling() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//  
	 Students students=new Students();
	 students.setStudents(new ArrayList<StudentRecords>());
	 StudentRecords student=new StudentRecords();
	  student.setEmail("anshikaagg@gmil.com");
	  student.setFirstname("anshika");
	  student.setLastname("aggarwal");
	  student.setPhonenumber("5667767689");
	  StudentRecords student1=new StudentRecords();
	  student1.setEmail("shremanishu.com");
	  student1.setFirstname("shrema");
	  student1.setLastname("singh");
	  student1.setPhonenumber("564547689");
	  students.getStudents().add(student);
	  students.getStudents().add(student1);
	  try {

		File file = new File("D:\\newfil1e.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(students, System.out);
		jaxbMarshaller.marshal(students, file);

		
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }

	}
}