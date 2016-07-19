package com.acco.marsh;

import java.io.FileOutputStream;  
import java.util.ArrayList;  
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
  
  
public class marshal {  
public static void main(String[] args) throws Exception{  
    JAXBContext contextObj = JAXBContext.newInstance(Addresses.class);  
  
    Marshaller marshallerObj = contextObj.createMarshaller();  
    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
  
     Name m=new Name();
     m.setFirstname("juhi");
     m.setLastname("jain");
    
     Name m1=new Name();
     m1.setFirstname("abc");
     m1.setLastname("xyz");
     
    Address ad1=new Address();  
    Address ad2=new Address();
    ad1.setEmail("abc@xyz.com");
    ad1.setName(m);
    ad1.setPhn(12345677);
    ad2.setEmail("abc@xyz.com");
    ad2.setName(m1);
    ad2.setPhn(77654421);
    
      
    ArrayList<Address> list=new ArrayList<Address>();  
    list.add(ad1);  
    list.add(ad2); 
    
    Addresses a=new Addresses();
    a.setAdress(list);
      
    //Question que=new Question(1,"What is java?",list);  
    marshallerObj.marshal(a, new FileOutputStream("address_new.xml"));  
    System.out.println("marshaled");
       
}  

}