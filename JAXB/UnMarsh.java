
/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Ravi Kalmodia

* ***************************************************************************

*/
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarsh {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {

			File file = new File("D:\\JaxbProject\\student.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Students sts = (Students) jaxbUnmarshaller.unmarshal(file);

			for (Student std : sts.getStudents()) {
				System.out.println(std.getFirstname());
				System.out.println(std.getLastname());
				System.out.println(std.getMarks());
				System.out.println(std.getRollno());
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
