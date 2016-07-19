package com.accolite.Marshel;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class Marshel {
	public static void main(String[] args) throws JAXBException {

		  /*Customer customer = new Customer();
		  customer.setId(100);
		  customer.setName("mkyong");
		  customer.setAge(29);

		  try {

			File file = new File("D:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }*/
			Employees employees = new Employees();
			employees.setEmployees(new ArrayList<Employee>());
		    //Create two employees

		    Employee emp1 = new Employee();
		    emp1.setId(1);
		    emp1.setFirstName("Sumeet");
		    emp1.setLastName("Kumar");
		    emp1.setIncome(0.00);
		     
		    Employee emp2 = new Employee();
		    emp2.setId(2);
		    emp2.setFirstName("Pawan");
		    emp2.setLastName("Sathyarthi");
		    emp2.setIncome(2.0);
		     
		    //Add the employees in list
		    employees.getEmployees().add(emp1);
		    employees.getEmployees().add(emp2);
		    
		    JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the employees list in console
		    jaxbMarshaller.marshal(employees, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(employees, new File("D:/employees.xml"));

		}
}
