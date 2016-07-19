package com.accolite.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLtoObject {
	
	public static void main(String[] args) {
		
		  try {  
			   
		        File file = new File("D:\\AU\\XMLAssignment\\src\\com\\accolite\\jaxb\\address.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Addresses.class);  
		   
		        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		        Addresses addresses= (Addresses) jaxbUnmarshaller.unmarshal(file);  
		          
		        System.out.println("Location id"+" "+addresses.getId());  
		        System.out.println("Addresses for "+addresses.getLocation()+":"); 
		        System.out.println("First Name \t Last Name \t  Email \t PhoneNumber");
		        System.out.println("-----------------------------------------------------------------------------------------------");
		        
		        List<Address> addressList=addresses.getAddresses();  
		        
		        for(Address addr:addressList)  
		          System.out.println(addr.getFirstName()+" \t"+addr.getLastName()+" \t "+addr.getEmail()+" \t "+addr.getPhoneNumber());  
		   
		      } catch (JAXBException e) {  
		        e.printStackTrace();  
		      }  
		  }
}
