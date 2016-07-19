package com.accolite.problem;

import java.io.File;
import java.util.ArrayList;
//import java.util.List;


import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class JAXBMarshaller {
   public static void main(String[] args) {
      AddList addList=new AddList();
      addList.students=new ArrayList<Student>(2);
      DOB d1=new DOB(03,1,1994);
      Student student1=new Student("Mohit", "Electrical", 22, d1, 1);
      DOB d2=new DOB(24,2,1994);
      Student student2=new Student("Jayesh", "CSE", 22, d2, 2);
      
      addList.students.add(student1);
      addList.students.add(student2);
      
      try {

  		File file = new File("new.xml");
  		JAXBContext jaxbContext = JAXBContext.newInstance(AddList.class);
  		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

  		// output pretty printed
  		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

  		jaxbMarshaller.marshal(addList, file);
  		jaxbMarshaller.marshal(addList, System.out);

  	      } catch (JAXBException e) {
  		e.printStackTrace();
  	      }
   }
}