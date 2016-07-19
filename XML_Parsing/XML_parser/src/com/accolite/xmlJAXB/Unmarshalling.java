package com.accolite.xmlJAXB;
import java.io.File;  
import java.util.List;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
public class Unmarshalling {

	public static void main(String args[]) {

	 
		   
		     try {  
		   
		        File file = new File("C:\\Users\\Pawan Prakash\\Desktop\\beforeUnmarshalling.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);  
		   
		        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		        Employees que= (Employees) jaxbUnmarshaller.unmarshal(file);  
		          
		        //System.out.println(que.getName()+"\n"+que.getEmail() + "\n" + que.getPhone());  
		        //System.out.println("Answers:");  
		       
		        List<Address> list=que.getAddresses();  
		        for(Address ans:list)  {
		          System.out.println("Name: " + ans.getName()+"\nEmail: "+ans.getEmail()+"\nPhone:  "+ans.getPhone());  
		          System.out.println("-----------------------------------------------------------------");
		        }
		   
		      } catch (JAXBException e) {  
		        e.printStackTrace();  
		      }  
		   
		
	}
}
