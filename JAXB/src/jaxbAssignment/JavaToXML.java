package jaxbAssignment;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;



//import java.io.File;
public class JavaToXML {
	public static void main(String[] args) throws Exception{  
	    JAXBContext contextObj = JAXBContext.newInstance(DemoClass.class);  
	  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	  
	    DemoClass emp1=new DemoClass("dinkar","kad","dinkar",23,1024);  
	      
	    marshallerObj.marshal(emp1, new FileOutputStream("DemoClass.xml"));  
	       
	}  

}
