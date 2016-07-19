/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Marsh;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {

	@XmlElement(name = "customer")
	private LinkedList<Customer> customerlist = null;

	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	public LinkedList<Customer> getCustomers() {
		return customerlist;
	}

	public void setCustomers(LinkedList<Customer> customers) {
		customerlist = customers;
	}
}
