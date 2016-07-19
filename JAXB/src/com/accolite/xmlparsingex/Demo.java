package com.accolite.xmlparsingex;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		JAXBContext contextObj = JAXBContext.newInstance(Addresses.class);  
		  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
//	  
	    Address add1=new Address(new Name("ankush","dhama"),"9996669996","2/1/1994");  
	    Address add2=new Address(new Name("gagan","jha"),"9996555596","4/6/1994");  
	      
	    ArrayList<Address> list=new ArrayList<Address>();  
	    list.add(add1);  
	    list.add(add2);  
	      
	  //  Question que=new Question(1,"What is java?",list);  
	    Addresses addresses_object=new Addresses(list);
	    
	    marshallerObj.marshal(addresses_object, new FileOutputStream("magic.xml"));
	  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
		File file = new File("extract.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Addresses.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Addresses addresses_obj= (Addresses) jaxbUnmarshaller.unmarshal(file);  
          
         
        System.out.println("Addresses:");  
        ArrayList<Address> list=addresses_obj.getList_of_addresses();  
        for(Address add:list)  
          System.out.println(add.getName().getFirst()+" "+ add.getName().getLast()+" " +add.getPhone_no()+"  "+add.getDate());  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
