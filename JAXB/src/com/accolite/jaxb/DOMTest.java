package com.accolite.jaxb;
/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class DOMTest.
 */
public class DOMTest {
	
	/**
	 * The main method.
	 *
	 * @param ars the arguments
	 * @throws JAXBException the JAXB exception
	 * @throws IOException 
	 */
	public static void main(String[] ars) throws JAXBException, IOException {
		Scanner in = new Scanner(System.in);
		Employee employee;
		JAXBContext jaxbc = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshal = jaxbc.createUnmarshaller();
		Marshaller marshal=jaxbc.createMarshaller();
		/** to create readable file */
		marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		System.out.println("Going to Marshel");
		boolean doLoop=true;
		while(doLoop){
			System.out.println("Enter\n1.create employee xml\n2.view employee\n3.exit");
			switch(in.nextInt()){
			case 1:	System.out.println("Enter firstname,lastname,day of birth,month of birth,year of birth,phone:");
					String firstName=in.next();
					String lastName=in.next();
					int day=in.nextInt();
					int month=in.nextInt();
					int year=in.nextInt();
					String phone=in.next();
					System.out.println("Enter #emails:");
					int noOfEmails=in.nextInt();
					List<String> email=new ArrayList<String>();
					System.out.println("Enter emails one by one:");
					for (int i = 0; i < noOfEmails; i++) {
						email.add(in.next());
					}
					/** creating the employee object which will be marshalled into xml file*/
					employee = new Employee(new Address(new Name(firstName,lastName),email,phone,new Birthday(year,month,day)));
					/** marshaller marshals employee object into xml file*/
					marshal.marshal(employee, new PrintWriter(new FileWriter(new File(firstName+".xml"))));
					break;
			case 2: System.out.println("Enter employee firstname");
					String name=in.next();
					try{
						/** gets xml file of the given employee if exist*/
						File f=new File(name+".xml");
						employee = (Employee) unmarshal.unmarshal(f);
						System.out.println("FirstName: "+employee.getAddress().getName().getFirst());
						System.out.println("LastName: "+employee.getAddress().getName().getLast());
						System.out.println("DOB: "+employee.getAddress().getBirthday().getDay()+"/"+employee.getAddress().getBirthday().getMonth()+"/"+employee.getAddress().getBirthday().getYear());
						System.out.println("Phone: "+employee.getAddress().getPhone());
						for(String e:employee.getAddress().getEmail()){ //since our can have multiple emails, looping through each one
							System.out.println("email: "+e);
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("Something went wrong, given employee might not exist");
					}
				break;
			default:doLoop=false;
			}
		}
	}
}
