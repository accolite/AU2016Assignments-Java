/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.marshallunmarshall;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshalling {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int rollno = 111203035;
		String city = "Bangalore";
		String name = "BMS College";
		float cgpa = 9.34f;
		int nostudents;
		System.out.println("Enter total number of students in classroom");
		Scanner in = new Scanner(System.in);
		nostudents = in.nextInt();
		ArrayList<Student> l = new ArrayList<Student>();
		for( int b = 0; b < nostudents; b++ )
		{
			System.out.println("Enter student's rollno");
			rollno = in.nextInt();
			in.nextLine();
			System.out.println("Enter college city");
			city = in.nextLine();
			System.out.println("Enter college name");
			name = in.nextLine();
			System.out.println("Enter CGPA");
			cgpa = in.nextFloat();
			Student Udit = new Student(rollno, new College(city, name), cgpa);
			l.add( Udit );
		}
		Classroom c = new Classroom(l);
		JAXBContext marshallercontextObj;
		try {
			marshallercontextObj = JAXBContext.newInstance(Classroom.class);
			Marshaller marshaller = marshallercontextObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal( c, new FileOutputStream("classroom.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
