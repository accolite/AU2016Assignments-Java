/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.xmlDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

// TODO: Auto-generated Javadoc
/**
 * The Class Marshellar.
 */
public class Marshellar {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException{
		String name,id,contact,designation,email,hometown;
		Scanner sc=new Scanner(System.in);
		List<Employee> employee = new ArrayList<Employee>();
		String flag="true";
		while(flag.equals("true")){        //getting the values from user
			System.out.println("Enter name:");   
			name=sc.nextLine();
			System.out.println("Enter Id:");
			id=sc.nextLine();
			System.out.println("Enter Designation:");
			designation=sc.nextLine();
			System.out.println("Enter Contact:");
			contact=sc.nextLine();
			System.out.println("Enter email:");
			email=sc.nextLine();
			System.out.println("Enter Hometown:");
			hometown=sc.nextLine();
			employee.add(new Employee(name,id,designation,contact,email,hometown));
			name=id=designation=contact=email=hometown=null;
			System.out.println("Continue?? Yes->true/No->false");
			flag=sc.nextLine();
		}
		Company company=new Company(employee);    //calling constructor
        
        try {
        	File file = new File("D:\\Training\\Eclipse_Workspace\\XML\\src\\com\\accolite\\xmlDemo\\pojo_to_xml.xml");   //xml file  
            JAXBContext jaxbcontent = JAXBContext.newInstance(Company.class);
            Marshaller companyMarshellar = jaxbcontent.createMarshaller();
            // To format the xml file
            companyMarshellar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            companyMarshellar.marshal(company,new PrintWriter(new FileWriter(file)));  //writing into the file
            System.out.println("Done");
            
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

	}
	
	
}
