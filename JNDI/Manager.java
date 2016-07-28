package com.au.tomcat.assignment;

import java.util.List;

public class Manager {

	List<Employee> employees;
	
	public Manager()
	{
		
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
