/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.xmlDemo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class Company.
 */
@XmlRootElement  
public class Company
{
    
    /** The employee. */
    private List<Employee> employee;

    /**
     * Instantiates a new company.
     */
    public Company() {
		super();
	}
    
    /**
     * Instantiates a new company.
     *
     * @param employee the employee
     */
    public Company(List<Employee> employee) {
		super();
		this.employee = employee;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	@XmlElement
	public List<Employee> getEmployee ()
    {
        return employee;
    }

    
	/**
	 * Sets the employee.
	 *
	 * @param Employee the new employee
	 */
	public void setEmployee (List<Employee> Employee)
    {
        this.employee = Employee;
    }

}