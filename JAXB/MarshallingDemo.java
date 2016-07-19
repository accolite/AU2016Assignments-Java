package com.accolite.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MarshallingDemo {
	public static void main(String[] args) {
		ArrayList<Person> aList = new ArrayList<Person>();
		Name name=null;
		Address address = null;
		DOB dob = null;
		int age = 0;
		String string1 = null;
		String string2 = null;
		String string3 = null;
		boolean more = true;
		int option;
		Scanner scanner = new Scanner(System.in);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try{
		while(more){
			System.out.println("Enter an option 1.enter values \n2. generate XML \n3.unmarshall from xml\n4.exit");
			option = scanner.nextInt();
			switch(option){
				case 1: System.out.println("Enter the following values");
					System.out.println("Enter first name");
					string1 = bufferedReader.readLine();
					System.out.println("Enter last name");
					string2 = bufferedReader.readLine();
					name = new Name(string1, string2);
					System.out.println("Enter date of dob");
					string1 = bufferedReader.readLine();
					System.out.println("Enter month of dob");
					string2= bufferedReader.readLine();
					System.out.println("Enter month of dob");
					string3 = bufferedReader.readLine();
					dob = new DOB(string1,string2,string3);
					System.out.println("Enter city");
					string1 = bufferedReader.readLine();
					System.out.println("Enter state");
					string2 = bufferedReader.readLine();
					System.out.println("enter country");
					string3 = bufferedReader.readLine();
					address = new Address(string1, string2, string3);
					System.out.println("enter age");
					age = scanner.nextInt();
					Person person = new Person(name, dob, address, age);
					aList.add(person);
					break;
				case 2: 
					PersonList personList = new PersonList();
					personList.setaList(aList);
					JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
				    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				    
				    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				 
				    jaxbMarshaller.marshal(personList, System.out);
				    jaxbMarshaller.marshal(personList, new File("C:\\Users\\Balaji P\\Documents\\persons.xml"));
				    break;
				case 3:
					JAXBContext jaxbContext1 = JAXBContext.newInstance(PersonList.class);
				    Unmarshaller jaxbUnmarshaller = jaxbContext1.createUnmarshaller();
				    PersonList personList2 = (PersonList) jaxbUnmarshaller.unmarshal( new File("C:\\Users\\Balaji P\\Documents\\persons.xml") );
				    ArrayList<Person> ummarshallPersonList = personList2.getaList(); 
				    
				    Iterator<Person> iterator = ummarshallPersonList.iterator();
				    while (iterator.hasNext()) {
						Person unmarshallPerson = (Person) iterator.next();
						Name unmarshallName = unmarshallPerson.getName();
						DOB unmarshallDOB = unmarshallPerson.getDob();
						Address unmarshallAddress = unmarshallPerson.getAddress();
						int unmarshallAge = unmarshallPerson.getAge();
						
						System.out.println("First Name: "+unmarshallName.getFirstName()+"\nLast Name: "+unmarshallName.getLastName()+""
								+ "\nDay: "+unmarshallDOB.getDate()+"\nMonth "+unmarshallDOB.getMonth()+"\nYear "+unmarshallDOB.getYear()+""
										+ "\ncity: "+unmarshallAddress.getCity()+"\nstate: "+unmarshallAddress.getState()+""
												+ "\ncountry: "+unmarshallAddress.getCountry()+"\n\n");
						
						
				case 4: more = false;
					break;

				default: System.out.println("Enter correct option");
					
					}
			    
			}
		} 
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
