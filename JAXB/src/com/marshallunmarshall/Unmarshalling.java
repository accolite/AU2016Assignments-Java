/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.marshallunmarshall;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class Unmarshalling.
 */
public class Unmarshalling {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			File file = new File("classroom.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Classroom.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Classroom c = (Classroom) jaxbUnmarshaller.unmarshal(file);
			for (Student Udit : c.getClassroom())
				System.out.println(Udit.getRollno() + " " + Udit.getColl().getCity() + " " + Udit.getColl().getName()
						+ " " + Udit.getCGPA());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
