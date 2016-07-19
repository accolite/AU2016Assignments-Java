/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package com.accolite.marshallingUnmarshalling;


import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class Marshalling.
 */
public class Marshalling {

	/** The employees. */
	//Initialize the employees list
	static Employees employees = new Employees();
	static
	{
	    employees.setEmployees(new ArrayList<Employee>());
	    //Create two employees 
	    
	    Employee employee1 = new Employee();
	    employee1.setId(1);
	    employee1.setFirstName("Diksha");
	    employee1.setLastName("Garg");
	    employee1.setPhoneNumber(98765432);
	    employee1.setAddress("ABC");
	    employee1.setPincode(148101);
	    
	    Employee employee2 = new Employee();
	    employee2.setId(2);
	    employee2.setFirstName("Anshika");
	    employee2.setLastName("Sharma");
	    employee2.setPhoneNumber(9876012);
	    employee2.setAddress("XYZ");
	    employee2.setPincode(123456);
	     
	    //Add the employees in list
	    employees.getEmployees().add(employee1);
	    employees.getEmployees().add(employee2);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		try{
		    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the employees list in console
		    jaxbMarshaller.marshal(employees, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(employees, new File("D:/AU/eclipse/MarshallingUnmarshalling/employees.xml"));
		}catch(Exception e){
			
			System.out.println("Exception is: "+e);
			
		}
	}
	
		
			
	
}
