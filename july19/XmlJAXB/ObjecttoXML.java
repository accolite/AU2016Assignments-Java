package com.accolite.xmldom;
import java.io.FileOutputStream;
  
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
    Name name=new Name("Rooney", "Wayne");  
    Birthday birthday=new Birthday("10", "25", "1985");  
      
    Address que=new Address(birthday, "9171337464", "wayne@manutd.com", name);  
    
    /**
     * Marshall to file
     */
    marshallerObj.marshal(que, new FileOutputStream("D:/address.xml"));  
       
}  
}  