package com.accolite.au.jaxb.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees{
	
	@XmlElement(name = "Employee")
	List<Employee> emps;

	public List<Employee> getEmployees() {
		return emps;
	}

	public void setEmployees(List<Employee> emps) {
		this.emps = emps;
	}
	
}