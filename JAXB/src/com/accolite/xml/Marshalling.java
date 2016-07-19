package com.accolite.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshalling {

 public Marshalling() {
  // TODO Auto-generated constructor stub
 }

 public static void main(String[] args) {
  //  
  Students students=new Students();
  students.setStudents(new ArrayList<StudentRecords>());
  StudentRecords student=new StudentRecords();
   student.setEmail("anshika.agarwal@accoliteindia.com");
   student.setFirstname("anshika");
   student.setLastname("agarwal");
   student.setPhonenumber("123456789");
   StudentRecords student1=new StudentRecords();
   student1.setEmail("anshika1448@iiitd.ac.in");
   student1.setFirstname("anshi");
   student1.setLastname("agarwal");
   student1.setPhonenumber("987654321");
   students.getStudents().add(student);
   students.getStudents().add(student1);
   try {

  File file = new File("D:\\NewFile.xml");
  JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
  Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
  
  // output pretty printed
  jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
  jaxbMarshaller.marshal(students, System.out);
  jaxbMarshaller.marshal(students, file);

  
       } catch (JAXBException e) {
  e.printStackTrace();
       }

 }
}