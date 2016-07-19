package pkg;
import java.io.File;  
import java.util.List;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
public class Unmarshalling {  
    public static void main(String[] args) {  
   
     try {  
   
        File file = new File("D:\\address1.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Add_List.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Add_List que= (Add_List) jaxbUnmarshaller.unmarshal(file);  
            
        List<Address> list=que.getList();  
        for(Address ans:list)  
          System.out.println(ans.ph_no+" "+ans.name+"  "+ans.birth);  
   
      } catch (JAXBException e) {  
        e.printStackTrace();  
      }  
   
    }  
}  