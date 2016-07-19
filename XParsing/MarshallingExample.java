package Assignment;

import java.io.FileOutputStream;  
import java.util.ArrayList;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
  
  
public class MarshallingExample {  
public static void main(String[] args) throws Exception{  
    JAXBContext contextObj = JAXBContext.newInstance(Company.class);  
  
    Marshaller marshallerObj = contextObj.createMarshaller();  
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
    Employee e1 = new Employee(396, "Rick", "D'Souza", "Rick");
    Employee e2 = new Employee(397, "Jasmine", "Knight", "Jase");  
      
    ArrayList<Employee> list=new ArrayList<Employee>();  
    list.add(e1);  
    list.add(e2);  
      
    Company c=new Company(1 , list);  
    marshallerObj.marshal(c, new FileOutputStream("output.xml"));  
       
}  
} 
