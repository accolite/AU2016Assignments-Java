package Assignment;

import java.io.File;
import java.util.List;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
public class UnmarshallerExample {  
    public static void main(String[] args) {  
   
     try {  
   
        File file = new File("input.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Company c = (Company) jaxbUnmarshaller.unmarshal(file); 
        
        System.out.println(c.getId());  
        System.out.println("employees:");  
        List<Employee> list=c.getEmployees();  
        for(Employee ans:list)  
          System.out.println(ans.getId()+" "+ans.getfName()+"  "+ans.getlName());
      } catch (JAXBException e) {  
        e.printStackTrace();  
      }  
    }  
}  
