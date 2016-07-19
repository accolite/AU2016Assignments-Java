package jaxbAssignment;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class XmlToJava {
	public static void main(String[] args) {  
	     try {    
	            File file = new File("DemoClass.xml");    
	            JAXBContext jaxbContext = JAXBContext.newInstance(DemoClass.class);    
	         
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
	            DemoClass e=(DemoClass) jaxbUnmarshaller.unmarshal(file); 
	            
	            System.out.println(e.getRollno()+" "+e.getFirstname()+" "+e.getMarks());  
	              
	          } catch (JAXBException e) {e.printStackTrace(); }    
	         
	}  

}
