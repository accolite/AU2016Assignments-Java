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
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class unmarshalling.
 */
public class unmarshalling {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		try {

			File file = new File("D:/sample2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Address3.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Address3 address = (Address3) jaxbUnmarshaller.unmarshal(file);

			for (Address a : address.getAddress3()) {
				System.out
						.println(a.getName().first + " " + a.getName().last + " " + a.getEmail() + "  " + a.getPhone());
				System.out.println(a.getBday().day + " " + a.getBday().month + " " + a.getBday().year);
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}