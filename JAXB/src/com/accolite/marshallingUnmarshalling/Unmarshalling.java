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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class Unmarshalling.
 */
public class Unmarshalling {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try{
		    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("D:/AU/eclipse/MarshallingUnmarshalling/employees.xml") );
		     
		    for(Employee emp : emps.getEmployees())
		    {
		        System.out.println("Id: "+emp.getId());
		        System.out.println("First Name: "+emp.getFirstName());
		        System.out.println("Last Name: "+emp.getLastName());
		        System.out.println("Phone Number: "+emp.getPhoneNumber());
		        System.out.println("Address: "+emp.getAddress());
		        System.out.println("Pincode: "+emp.getPincode());
		        System.out.println("\n");
		    }
		}catch(Exception e){
			
			System.out.println("Exception: "+e);
			
		}
	}

}
