package Parsing;

import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Marshalling {
	public static void main(String[] args) throws Exception{  
	    JAXBContext contextObj = JAXBContext.newInstance(Address.class);  
	  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    
	      
	    Address add=new Address("Arnika Titoria","9560250811","arnikatitoria@yahoo.com");  
	    marshallerObj.marshal(add, new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Address.xml"));  
	       
	}
}
