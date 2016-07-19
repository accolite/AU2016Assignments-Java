package com.accolite.xmlJAXB;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Marshalling {
	public static void main(String[] args) throws Exception{  
		
		JAXBContext contextObj = JAXBContext.newInstance(Employees.class);  
		Marshaller marshallerObj = contextObj.createMarshaller();  
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		
		Address que1=new Address("pawan","pawan@gmail.com","8019463072", "1");  
		Address que2=new Address("karan","karan@gmail.com","8019463072", "2"); 
		Address que3=new Address("soman","soman@gmail.com","8019463072", "3"); 
		Address que4=new Address("vansh","vansh@gmail.com","8019463072", "4"); 
		ArrayList<Address> list=new ArrayList<Address>();  
	    list.add(que1);  
	    list.add(que2);
	    list.add(que3);  
	    list.add(que4);
	    
	    Employees emp = new Employees(list);
		
		marshallerObj.marshal(emp, new FileOutputStream("C:\\Users\\Pawan Prakash\\Desktop\\afterMarshalling.xml"));  
		
		
	    
		}
}
