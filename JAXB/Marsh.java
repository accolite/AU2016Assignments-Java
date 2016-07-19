
/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Ravi Kalmodia

* ***************************************************************************

*/
import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;

public class Marsh {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Students sts = new Students();
		sts.setStudents(new ArrayList<Student>());
		char ch = 'y';
		while (ch == 'y') {
			System.out.println("Enter the Name,LastName,Marks,RollNo:");
			Student st = new Student();
			st.setFirstname(sc.next());
			st.setLastname(sc.next());
			st.setMarks(sc.nextInt());
			st.setRollno(sc.nextInt());
			sts.getStudents().add(st);
			System.out.println("Want to Continue y/n: ");
			ch = sc.next().charAt(0);
		}

		// sts.setStudents(Students);
		File file = new File("D:\\JaxbProject\\student.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(sts, file);
		jaxbMarshaller.marshal(sts, System.out);

	}
}
