package jaxbAssignment;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
public class Unmarshalling {
	
	public static void main(String[] args) throws Exception{  
		  try {    
	            File file = new File("ExampleNesting.xml");    
	            JAXBContext jaxbContext = JAXBContext.newInstance(Example.class);    
	         
	            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
	            Example e=(Example) jaxbUnmarshaller.unmarshal(file); 
	            ArrayList<Student> student=e.getStudent();
	            System.out.println(student.get(0).getFirstname());
	            System.out.println(student.get(1).getFirstname());
	              
	          } catch (JAXBException e) {e.printStackTrace(); }    
	          
	       
	}  

}
