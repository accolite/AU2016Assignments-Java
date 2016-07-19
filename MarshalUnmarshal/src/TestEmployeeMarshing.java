/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class TestEmployeeMarshing.
 */
public class TestEmployeeMarshing 
{
	
	/** The employees. */
	static Employees employees = new Employees();
	static 
	{
		employees.setEmployees(new ArrayList<Employee>());
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("Arnik");
		emp.setLastName("Gupta");
		emp.setIncome(100.0);
		
		Employee emp1 = new Employee();
		emp1.setId(2);
		emp1.setFirstName("Loghitha");
		emp1.setLastName("vani");
		emp1.setIncome(2000.0);
		
		employees.getEmployees().add(emp);
		employees.getEmployees().add(emp1);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws JAXBException the JAXB exception
	 */
	public static void main(String[] args) throws JAXBException 
	{
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}

	/**
	 * Un marshaling example.
	 *
	 * @throws JAXBException the JAXB exception
	 */
	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("employees.xml") );
		
		for(Employee emp : emps.getEmployees())
		{
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
		}
	}

	/**
	 * Marshaling example.
	 *
	 * @throws JAXBException the JAXB exception
	 */
	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(employees, System.out);
		jaxbMarshaller.marshal(employees, new File("employees.xml"));
	}
}
