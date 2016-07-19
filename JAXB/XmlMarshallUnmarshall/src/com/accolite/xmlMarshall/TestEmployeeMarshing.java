package com.accolite.xmlMarshall;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TestEmployeeMarshing 
{
	static Employees employees = new Employees();
	//This is exceuted once as code starts its execution
	static 
	{
		employees.setEmployees(new ArrayList<Employee>());
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("Sachin");
		emp.setLastName("Gupta");
		emp.setIncome(40000000.0);
		employees.getEmployees().add(emp);
		emp = new Employee();
		emp.setId(2);
		emp.setFirstName("Momin");
		emp.setLastName("Yadav");
		emp.setIncome(10000000.0);
		employees.getEmployees().add(emp);
		
	}
	
	public static void main(String[] args) throws JAXBException 
	{
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("D:/Projects On Eclipse/JAXBDemo_List_Set/JAXBDemo/first.xml") );
		
		for(Employee emp : emps.getEmployees())//For iterating over list of employees function is used as list is private
		{
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(employees, System.out);
		jaxbMarshaller.marshal(employees, new File("D:/Projects On Eclipse/JAXBDemo_List_Set/JAXBDemo/first.xml"));
	}
}
