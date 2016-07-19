/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package com.accolite.marshallingUnmarshalling;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Employees.
 */
@XmlRootElement
public class Employees {

	 
	    /** The employees. */
    	private List<Employee> employees = null;
	    
	    /**
    	 * Gets the employees.
    	 *
    	 * @return the employees
    	 */
    	public List<Employee> getEmployees() {
	        return employees;
	    }
	 
	    /**
    	 * Sets the employees.
    	 *
    	 * @param employees the new employees
    	 */
    	public void setEmployees(List<Employee> employees) {
	        this.employees = employees;
	    }
	
}
