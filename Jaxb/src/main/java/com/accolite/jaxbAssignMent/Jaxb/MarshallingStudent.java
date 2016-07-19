package com.accolite.jaxbAssignMent.Jaxb;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MarshallingStudent {
	public static void main(String[] args) throws JAXBException 
	{
	    HashMap<Integer, student> map = new HashMap<Integer, student>();
	     
	    student student1 = new student();
	    student1.setRollno(393);;
	    student1.setFirstname("Vishal");
	    student1.setLastname("Goyal");
	    student1.setNickname("lundry");
	     
	    student student2 = new student();
	    student2.setRollno(493);;
	    student2.setFirstname("Shailendra");
	    student2.setLastname("Verma");
	    student2.setNickname("Sunny");
	     
	    map.put( 1 , student1);
	    map.put( 2 , student2);
	     
	    //Add students in map
	    StudentMap studentMap = new StudentMap();
	    studentMap.setStudentMap(map);
	     
	    // Marshalling //
	     
	    JAXBContext jaxbContext = JAXBContext.newInstance(StudentMap.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
	    jaxbMarshaller.marshal(studentMap, System.out);
	    jaxbMarshaller.marshal(studentMap, new File("C:/Users/Vishal Goyal/Desktop/AssignMent.xml"));
	    
	    //UnMarshalling //
	    try{
	     jaxbContext = JAXBContext.newInstance(StudentMap.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    studentMap = (StudentMap) jaxbUnmarshaller.unmarshal( new File("C:/Users/Vishal Goyal/Desktop/AssignMent.xml") );
	     
	    for(Integer  key : studentMap.getStudentMap().keySet()){
	    	System.out.println(studentMap.getStudentMap().get(key).getFirstname());
	    	System.out.println(studentMap.getStudentMap().get(key).getLastname());
	    	System.out.println(studentMap.getStudentMap().get(key).getRollno());
	    	System.out.println(studentMap.getStudentMap().get(key).getNickname());
	    }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
}

