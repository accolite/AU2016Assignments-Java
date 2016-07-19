package com.accolite.marshallingUnmarshalling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Unmarshalling {
	
	 public static void main(String[] args) {
		  try{
		      JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		       
		      Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("C:/Users/SUKO-HYD-01/workspace/MarshallingUnmarshalling/src/com/accolite/marshallingUnmarshalling/employees.xml") );
		       
		      for(Employee emp : emps.getEmployees())
		      {
		          System.out.println("Id: "+emp.getId());
		          System.out.println("First Name: "+emp.getFirstName());
		          System.out.println("Last Name: "+emp.getLastName());
		          System.out.println("mobile Number: "+emp.getmobileNumber());
		          System.out.println("permanentAddress: "+emp.getpermanentAddress());
		          System.out.println("areaPincode: "+emp.getareaPincode());
		          System.out.println("\n");
		      }
		  }catch(Exception e){
		   
		   System.out.println("Exception: "+e);
		   
		  }
		 }

}
