/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class marshalling.
 */
public class marshalling {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		Address3 a = new Address3();
		a.setAddress3(new ArrayList<Address>());

		Address address = new Address();
		// address.setName("Alice Lee");
		Name n = new Name();
		n.first = "Momin";
		n.last = "Yadav";
		address.setName(n);
		address.setEmail("alee@aol.com");
		address.setPhone("212-346-1234");

		Birthday b = new Birthday();
		b.day = 3;
		b.month = 10;
		b.year = 1994;
		address.setBday(b);
		a.getAddress3().add(address);
		a.getAddress3().add(address);
		System.out.println(a);
		try {

			File file = new File("D:/sample2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Address3.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(a, file);
			jaxbMarshaller.marshal(a, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}