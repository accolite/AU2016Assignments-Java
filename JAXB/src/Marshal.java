/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshal {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws JAXBException the JAXB exception
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws JAXBException, FileNotFoundException{
		List<Address> list = new ArrayList<Address>();
		
		JAXBContext contextObj = JAXBContext.newInstance(ParentAddress.class);  
		  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    
	    Name name1 = new Name("ankush","dhama");
	    Name name2 = new Name("chirag","bansal");
	  
	    Address add1= new Address(22,34,name1);
	    Address add2= new Address(99,184,name2);
	    
	    list.add(add1);
	    list.add(add2);
	    ParentAddress obj = new ParentAddress();
	    obj.setList(list);
	    
	     
	    marshallerObj.marshal(obj, new FileOutputStream("address.xml"));
		System.out.println("The End");
	}

}
