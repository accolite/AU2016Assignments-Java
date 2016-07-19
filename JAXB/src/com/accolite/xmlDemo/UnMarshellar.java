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
import java.util.List;  
 
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
   
// TODO: Auto-generated Javadoc
/**
 * The Class UnMarshellar.
 */
public class UnMarshellar {  
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {  
   
     try {  
   
        File file = new File("D:\\Training\\Eclipse_Workspace\\XML\\src\\com\\accolite\\xmlDemo\\input.xml");  //reading the xml file
        JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Company company= (Company) jaxbUnmarshaller.unmarshal(file);  
        List<Employee> emp=company.getEmployee();    //getting the employee object
        for(Employee employee:emp){
        	System.out.println("Name:"+employee.getName()+"\nId:"+employee.getId()+"\nDesignation:"+employee.getDesignation()+"\nContact:"+employee.getContact()+"\nemail:"+employee.getEmail()+"\nHomeTown:"+employee.getHometown());
        	System.out.println("--------------------------");
          }
        } catch (JAXBException e) {  
        	
        e.printStackTrace();  
      }  
   
    }  
}  