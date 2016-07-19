package com.au.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employees 
{
	@XmlElement(name = "address")
	private List<Employee> Employee = null;

	public List<Employee> getEmployees() {
		return Employee;
	}

	public void setEmployees(List<Employee> Employee) {
		this.Employee = Employee;
	}

}
