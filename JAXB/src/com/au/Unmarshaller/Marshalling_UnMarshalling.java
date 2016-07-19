/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.au.Unmarshaller;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import javax.xml.bind.Marshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class Marshalling_UnMarshalling.
 */
public class Marshalling_UnMarshalling {
	
	/** The table. */
	static TableMap table = new TableMap();
	static {

		table.setTable(new ArrayList<Table>());
		Table t1 = new Table();
		t1.setFirstname("Charan");
		t1.setLastname("Movva");
		t1.setMarks(75);
		t1.setNickname("movva");
		t1.setRollno(53);

		Table t2 = new Table();
		t2.setFirstname("Kiran");
		t2.setLastname("Movva");
		t2.setMarks(89);
		t2.setNickname("kiran");
		t2.setRollno(21);

		Table t3 = new Table();
		t3.setFirstname("Sriram");
		t3.setLastname("Guduri");
		t3.setMarks(80);
		t3.setNickname("sri");
		t3.setRollno(14);

		table.getTable().add(t1);
		table.getTable().add(t2);
		table.getTable().add(t3);
	}

	/**
	 * Marshaling.
	 *
	 * @throws JAXBException the JAXB exception
	 */
	private static void marshaling() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(TableMap.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(table, System.out);
		jaxbMarshaller.marshal(table, new File("D:\\input.xml"));
	}

	/**
	 * Un marshaling.
	 *
	 * @throws JAXBException the JAXB exception
	 */
	private static void unMarshaling() throws JAXBException {
		try {

			File file = new File("D:\\input.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(TableMap.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			TableMap std = (TableMap) (jaxbUnmarshaller.unmarshal(file));
			for (Table rollno : std.getTable()) {
				System.out.println(rollno.getFirstname());
				System.out.println(rollno.getLastname());
				System.out.println(rollno.getMarks());
				System.out.println(rollno.getNickname());
				System.out.println(rollno.getRollno());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws JAXBException the JAXB exception
	 */
	public static void main(String[] args) throws JAXBException 
	{
		marshaling();
		System.out.println("************************************************");
		unMarshaling();
	}
}
