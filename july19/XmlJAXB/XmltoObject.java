package com.accolite.xmldom;

import java.io.File;   
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
public class XmltoObject {  
    public static void main(String[] args) {  
   
     try {  
		/**
		 * Get JAXBContextext Object
		 */
        File file = new File("D:/addressOutput.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);  
   
        /**
         * Get Unmarshaller Object
         */
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        
        /**
         * Unmarshall to Object
         */
        Address add= (Address) jaxbUnmarshaller.unmarshal(file);  
          
        System.out.println(add); 
        
      } catch (JAXBException e) {  
        e.printStackTrace();  
      }  
   
    }  
} 
