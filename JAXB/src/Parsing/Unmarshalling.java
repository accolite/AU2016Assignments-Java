package Parsing;

import java.util.List;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Unmarshalling {
	  public static void main(String[] args) {  
		   
		     try {  
		   
		        File file = new File("C:\\Users\\Administrator\\Desktop\\Practice.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);  
		   
		        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		        Student stu= (Student) jaxbUnmarshaller.unmarshal(file);  
		          
		     //   System.out.println(add.getName()+" "+add.getPhone()+" "+add.getEmail());  
		        List<Address> list=stu.getAddress();  
		        for(Address add:list)  
		        	System.out.println(add.getId()+" "+add.getName()+" "+add.getPhone()+" "+add.getEmail());  
		      } catch (JAXBException e) {  
		        e.printStackTrace();  
		      }  
		   
		    }  
}
