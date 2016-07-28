package com.accolite.demo;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee {
	
	/** The name. */
	String name;
	
	/** The email. */
	String email;
	
	
/**
	 * Instantiates a new employee.
	 *
	 * @param name the name
	 * @param email the email
	 */
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee(){
		
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
		
}
