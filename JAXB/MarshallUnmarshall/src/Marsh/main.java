/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Marsh;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Want to enter y/n");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		LinkedList<Customer> list = new LinkedList<>();
		// Customer customer=null;
		while (choice.equals("Y") || choice.equals("y")) {
			Customer customer = new Customer();
			System.out.println("Enter ID");
			customer.setId(sc.nextInt());
			System.out.println("Enter Name");
			Name name = new Name();
			System.out.println("Enter First Name");
			name.setFirstname(sc.next());
			System.out.println("Enter Middle Name");
			name.setMiddlename(sc.next());
			System.out.println("Enter Last Name");
			name.setLastname(sc.next());
			customer.setName(name);
			System.out.println("Enter age");
			customer.setAge(sc.nextInt());
			list.add(customer);
			System.out.println("Want to enter more y/n :");
			choice = sc.next();
		}
		Customers customers = new Customers();
		customers.setCustomers(list);
		try {
			marshall(customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			unmarshall();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void unmarshall() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		// We had written this file in marshalling example
		Customers customers = (Customers) jaxbUnmarshaller.unmarshal(new File("D:\\test\\file.xml"));

		for (Customer customer : customers.getCustomers()) {
			System.out.println(customer.getId());
			System.out.println(customer.name.getFirstname() + " " + customer.name.getMiddlename() + " "
					+ customer.name.getLastname());
			System.out.println(customer.getAge());
		}
	}

	public static void marshall(Customers customers) throws JAXBException {
		File file = new File("D:\\test\\file.xml");

		JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(customers, file);
		jaxbMarshaller.marshal(customers, System.out);
	}
}
