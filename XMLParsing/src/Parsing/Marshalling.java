package Parsing;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Marshalling {
	public static void main(String[] args) throws Exception{  
	    JAXBContext contextObj = JAXBContext.newInstance(Student.class);  
	  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    Address add1=new Address(1,"Arnika Titoria","9560250811","arnikatitoria@yahoo.com");  
	    Address add2=new Address(2,"Anshika Sharma","9560250811","anshikasharma@yahoo.com");  
	    Address add3=new Address(3,"Safiya Rehmat","9560250811","safiyarehmat@yahoo.com"); 
	    ArrayList<Address> list=new ArrayList<Address>();  
	    list.add(add1);  
	    list.add(add2);  
	    list.add(add3);  
	    Student stu=new Student(list);
	    marshallerObj.marshal(stu, new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Student.xml"));  
	       
	}
}
