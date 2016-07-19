/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import java.io.File;  
import java.util.List;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
public class Unmarshal {  
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {  
   
     try {  
   
        File file = new File("address.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(ParentAddress.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        ParentAddress addr= (ParentAddress) jaxbUnmarshaller.unmarshal(file);  
          
        List<Address> list = addr.getList();
        
        for(Address add:list)
        System.out.println(add.getHno()+" "+add.getStreetno()+" "+add.getName().getFirstName()+" "+add.getName().getLastName());  
          
   
      } catch (JAXBException e) {  
        e.printStackTrace();  
      }  
   
    }  
}  