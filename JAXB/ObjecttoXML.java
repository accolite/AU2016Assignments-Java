package com.accolite.xmldom;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
  
  
public class ObjecttoXML {  
public static void main(String[] args) throws Exception{  
	
	/**
	 * Get JAXBContext object
	 */
    JAXBContext contextObj = JAXBContext.newInstance(Address.class);  
  
    /**
     * Get Marshaller
     */
    Marshaller marshallerObj = contextObj.createMarshaller();  
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
    /**
     * Set Object values
     */
    Scanner in = new Scanner(System.in);
    
    System.out.println("Enter Last Name");
    String last = in.next();
    System.out.println("Enter First Name");
    String first = in.next();
    
    Name name=new Name(last, first);
    System.out.println("Enter birthday in MM/DD/YYYY format");
    String bday = in.next();
    
    int firstSlash,secondSlash;
    firstSlash = bday.indexOf('/');
    secondSlash = firstSlash+1+bday.substring(firstSlash+1).indexOf('/');
    
    
    String mm = bday.substring(0, firstSlash);
    String dd = bday.substring(firstSlash+1,secondSlash);
    String yyyy = bday.substring(secondSlash+1);
    
    Birthday birthday=new Birthday(mm, dd, yyyy);  
    
    System.out.println("Enter Phone number");
    String phone = in.next();

    System.out.println("Enter Email");
    String email = in.next();
      
    Address add=new Address(birthday, phone, email, name);  
    
    /**
     * Marshall to file
     */
    marshallerObj.marshal(add, new FileOutputStream("D:/addressOutput.xml"));  
       
    in.close();
}  
}  