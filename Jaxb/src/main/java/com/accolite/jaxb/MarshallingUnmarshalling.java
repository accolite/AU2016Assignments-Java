package com.accolite.jaxb;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class MarshallingStudent.
 */
public class MarshallingUnmarshalling {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws JAXBException the JAXB exception
	 */
	public static void main(String[] args) throws JAXBException 
	{
	    HashMap<Integer, student> map = new HashMap<Integer, student>();
	     
	    student student1 = new student();
	    student1.setRollno(393);;
	    student1.setFirstname("Kartik");
	    student1.setLastname("Keshri");
	   
	     
	    student student2 = new student();
	    student2.setRollno(493);
	    student2.setFirstname("ravi");
	    student2.setLastname("kalmodia");
	   
	    
	    student student3 = new student();
	    student3.setRollno(123);
	    student3.setFirstname("abc");
	    student3.setLastname("cde");
	    map.put( 1 , student1);
	    map.put( 2 , student2);
	    map.put( 3 , student3);
	     
	    
	    StudentEntryMap studentMap = new StudentEntryMap();
	    studentMap.setStudentMap(map);
	     
	    
	    //marshalling 
	    JAXBContext jaxbContext = JAXBContext.newInstance(StudentEntryMap.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
	    jaxbMarshaller.marshal(studentMap, System.out);
	    jaxbMarshaller.marshal(studentMap, new File("C:/Users/Kartik Keshri.KAKE-BLR-01/Desktop/jaxb.xml"));
	    
	    //unmarshalling
	    try{
	     jaxbContext = JAXBContext.newInstance(StudentEntryMap.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    studentMap = (StudentEntryMap) jaxbUnmarshaller.unmarshal( new File("C:/Users/Kartik Keshri.KAKE-BLR-01/Desktop/jaxb.xml") );
	     
	    for(Integer  key : studentMap.getStudentMap().keySet()){
	    	System.out.println(studentMap.getStudentMap().get(key).getFirstname());
	    	System.out.println(studentMap.getStudentMap().get(key).getLastname());
	    	System.out.println(studentMap.getStudentMap().get(key).getRollno());
	    	
	    }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
}

