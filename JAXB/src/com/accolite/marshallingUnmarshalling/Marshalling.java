package com.accolite.marshallingUnmarshalling;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Marshalling {
	
	//Initialize the employees list
	 static Employees employees = new Employees();
	 static
	 {
	     employees.setEmployees(new ArrayList<Employee>());
	     //Create two employees 
	     
	     Employee employee1 = new Employee();
	     employee1.setId(1);
	     employee1.setFirstName("Suryateja");
	     employee1.setLastName("Rao");
	     employee1.setmobileNumber(9750719);
	     employee1.setpermanentAddress("Banjara Hills,Hyderabad");
	     employee1.setareaPincode(500036);
	     
	     Employee employee2 = new Employee();
	     employee2.setId(2);
	     employee2.setFirstName("Arjun");
	     employee2.setLastName("Nair");
	     employee2.setmobileNumber(987654);
	     employee2.setpermanentAddress("SainikPuri, Secunderabad");
	     employee2.setareaPincode(500016);
	      
	     //Add the employees in list
	     employees.getEmployees().add(employee1);
	     employees.getEmployees().add(employee2);
	 }
	 
	 public static void main(String args[])
	 {
	  try{
	      JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
	      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	   
	      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	       
	      //Marshal the employees list in console
	      jaxbMarshaller.marshal(employees, System.out);
	       
	      //Marshal the employees list in file
	      jaxbMarshaller.marshal(employees, new File("C:/Users/SUKO-HYD-01/workspace/MarshallingUnmarshalling/src/com/accolite/marshallingUnmarshalling/employees.xml"));
	  }catch(Exception e){
	   
	   System.out.println("Exception is: "+e);
	   
	  }
	  
	 }
}
	
