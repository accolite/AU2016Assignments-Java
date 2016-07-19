package com.accolite.marshallingUnmarshalling;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employees {
	
 private List<Employee> employees = null;
     
     public List<Employee> getEmployees() {
         return employees;
     }
  
     public void setEmployees(List<Employee> employees) {
         this.employees = employees;
     }

}
