package com.accolite.problem;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUnmarshaller {
	public static void main(String[] args) {

	 try {

		File file = new File("new.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(AddList.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AddList addlist = (AddList) jaxbUnmarshaller.unmarshal(file);
		for(Student student:addlist.getList())	{
			System.out.println("ID: "+student.getId());
			System.out.println("Name: "+student.getName());
			System.out.println("Branch: "+student.getBranch());
			System.out.println("Age: "+student.getAge());
			System.out.println("Date of Birth: "+student.getDob().getDay()+" / "+student.getDob().getMonth()+" / "+student.getDob().getYear()+"\n");


		}  } catch (JAXBException e) {
		e.printStackTrace();
	  }

	}
}