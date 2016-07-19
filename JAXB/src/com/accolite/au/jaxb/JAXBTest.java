package com.accolite.au.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.accolite.au.jaxb.util.Address;
import com.accolite.au.jaxb.util.Employee;
import com.accolite.au.jaxb.util.Employees;
import com.accolite.au.jaxb.util.Name;

public class JAXBTest {	
	
	public static void main(String[] args) {
		try{
			JAXBContext context = JAXBContext.newInstance(Employees.class);
			
			Employees employees = new Employees();
			List<Employee> emps = new ArrayList<Employee>();
			emps.add(new Employee(1, new Name("Rajesh", "R"), 23, new Address("Bangalore", "Karnataka", "India")));
			emps.add(new Employee(2, new Name("Ganesh", "A"), 24, new Address("Chennai", "Tamilnadu", "India")));
			emps.add(new Employee(3, new Name("Ramesh", "S"), 23, new Address("Bangalore", "Karnataka", "India")));
			employees.setEmployees(emps);
			
			Marshaller jaxbMarshaller = context.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
			//Marshalling to XML file
		    jaxbMarshaller.marshal(employees, new File("marshelled.xml"));

		    Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

		    //Unmarshalling from XML file
		    Employees emps_un = (Employees)jaxbUnmarshaller.unmarshal(new File("marshelled.xml"));
		    
		    for(Employee e : emps_un.getEmployees()){
		    	System.out.println("ID : "+e.getId());
		    	System.out.println("Name : "+e.getName().toString());
		    	System.out.println("Age : "+e.getAge());
		    	System.out.println("Address : "+e.getAddress().toString());
		    	System.out.println();
		    }
		}
		catch(JAXBException e){
			e.printStackTrace();
		}		
	}
}
