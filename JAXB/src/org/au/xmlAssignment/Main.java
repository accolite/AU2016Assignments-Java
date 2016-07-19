package org.au.xmlAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
	    JAXBContext contextObj = JAXBContext.newInstance(Addresses.class);  
	    
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	  

	    System.out.println("How many addresses ? ");
	    Scanner in = new Scanner(System.in);
	    
	    int n = in.nextInt();
	    for (int i = 0; i < n; i++) {
			
		    Address add1;

	    	System.out.println("Enter First Name, Last Name, Email, Phone, Year, Month, Day. Each in a new line");
	    	String fname = in.next();
	    	String lname = in.next();
	    	String email = in.next();
	    	Long phone = in.nextLong();
	    	int y=in.nextInt();
	    	int m=in.nextInt();
	    	int d=in.nextInt();
	    	add1 = new Address(fname, lname, email, phone, y, m, d);
		    	
	    }
	    
	    List<Address> l = new ArrayList<Address>();
	    l.add(new Address("Blue", "Nob","qwe@345.com", 50000L, 1992, 2, 3)); 
	    l.add(new Address("Blue", "Nob","qwe@345.com", 50000L, 1992, 2, 3)); 
	    l.add(new Address("Blue", "Nob","qwe@345.com", 50000L, 1992, 2, 3)); 
	    
	    Addresses addrs=new Addresses(l);
	      
	    marshallerObj.marshal(addrs, new FileOutputStream("D:\\addresslist.xml"));  
	    System.out.println("File Generated -> D:\\addresslist.xml");
	    
        File file = new File("D:\\addressInput.xml");    
        JAXBContext jaxbContext = JAXBContext.newInstance(Addresses.class);    
     
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
        Addresses addresses=(Addresses) jaxbUnmarshaller.unmarshal(file);    
        for(Address address : addresses.getAddresses()){
        	System.out.println(address);  
        }
	}
}
