package com.accolite.Unmarshel;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.accolite.Marshel.Employee;
import com.accolite.Marshel.Employees;



public class Unmarshel {

	public static void main(String[] args) throws JAXBException {

		 /*try {

			File file = new File("D:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			
			System.out.println(customer);
			System.out.println(customer.getName());
			System.out.println(customer.getId());
			System.out.println(customer.getAge());
			
			
			

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }*/
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	 
	    Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("D:/employees.xml") );
	     
	    for(Employee emp : emps.getEmployees())
	    {
	        System.out.println(emp.getId());
	        System.out.println(emp.getFirstName());
	    }

		}

}
