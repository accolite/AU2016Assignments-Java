package com.au.jaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.au.jaxb.Employee.Birthday;

import java.util.Scanner;
public class TestEmployeeMarshing 
{
	static Employees employees = new Employees();
	static 
	{
		int count;
		int id;
		int day,month,year;
		String fName,lName,email,phone;
		Scanner input = new Scanner(System.in);
		employees.setEmployees(new ArrayList<Employee>());
		System.out.println("How many employee you want to enter:");
		count = input.nextInt();
		for(int i=0;i<count;i++){
		Employee emp = new Employee();
		Employee.Birthday bt = new Birthday();
		System.out.println("Enter id / firstName / lastName /email / phone");
		id = input.nextInt();
		fName = input.next();
		lName = input.next();
		email = input.next();
		phone = input.next();
		System.out.println("Enter Birthday Day Month Year");
		day = input.nextInt();
		month = input.nextInt();
		year = input.nextInt();
		emp.setId(id);
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setEmail(email);
		emp.setPhone(phone);
		bt.setDay(day);
		bt.setMonth(month);
		bt.setYear(year);
		emp.setBirthday(bt);
		employees.getEmployees().add(emp);
		}
	}
	
	public static void main(String[] args) throws JAXBException 
	{
		marshalingExample();
		System.out.println("----------------------------------------------");
		unMarshalingExample();
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("employees.xml") );
		
		for(Employee emp : emps.getEmployees())
		{
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getBirthday().getYear());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(employees, System.out);
		jaxbMarshaller.marshal(employees, new File("employees.xml"));
	}
}
