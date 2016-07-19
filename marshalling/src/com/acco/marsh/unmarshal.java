package com.acco.marsh;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class unmarshal {
	private  void unMarshalingExample() throws JAXBException 
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(Addresses.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	     
	    
	    Addresses adds = (Addresses) jaxbUnmarshaller.unmarshal( new File("C:/Users/Juhi Jain/workspace/marshalling/address_new.xml") );
	     
	    for(Address add:adds.getAdreess())
	    {
	        System.out.println(add.getPhn());
	        System.out.println(add.getEmail());
	        System.out.println(add.getName().getFirstname());
	        System.out.println(add.getName().getLastname());
	   	 
	        
	    }
	        
	    
	}
	
	public static void main(String agrs[])
	{
		unmarshal un_marsh=new unmarshal();
		try {
			un_marsh.unMarshalingExample();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
