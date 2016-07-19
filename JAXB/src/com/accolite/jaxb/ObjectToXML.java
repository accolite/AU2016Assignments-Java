package com.accolite.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ObjectToXML {

	public static void main(String[] args) throws JAXBException {

		JAXBContext contextObj = JAXBContext.newInstance(Addresses.class);  
		  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	  
	    Address addr1=new Address("Gouthami","Mogili","gouthami.mogili@gmail.com","9876543210");  
	    Address addr2=new Address("G","M","gouthami.mogili@accoliteindia.com","9999999999");  
	      
	    ArrayList<Address> list=new ArrayList<Address>();  
	    list.add(addr1);  
	    list.add(addr2);  
	      
	    Addresses addresses=new Addresses(1,"Telangana",list);  
	    
	    try {
	    	
			marshallerObj.marshal(addresses, new FileOutputStream("D:\\AU\\XMLAssignment\\src\\com\\accolite\\jaxb\\address.xml"));
		
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}
}
