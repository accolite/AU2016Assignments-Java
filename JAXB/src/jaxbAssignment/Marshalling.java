package jaxbAssignment;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Marshalling {
	public static void main(String[] args) throws Exception{  
	    JAXBContext contextObj = JAXBContext.newInstance(Example.class);  
	  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    Student ans1=new Student("first","last","ravi",23,35);  
	    Student ans2=new Student("sec","last","john",23,56);
	    
	    ArrayList<Student> list=new ArrayList<Student>();  
	    list.add(ans1);  
	    list.add(ans2);
	    Example emp1=new Example(list);  
	      
	    marshallerObj.marshal(emp1, new FileOutputStream("ExampleUnmarshaling.xml"));  
	       
	}

}
