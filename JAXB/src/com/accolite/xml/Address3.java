/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
// TODO: Auto-generated Javadoc

/**
 * The Class Address3.
 */
@XmlRootElement(name = "address3")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address3 {

	/** The address 3. */
	@XmlElement(name = "address")
	List<Address> address3 = null;

	/**
	 * Gets the address 3.
	 *
	 * @return the address 3
	 */
	public List<Address> getAddress3() {
		return address3;
	}

	/**
	 * Sets the address 3.
	 *
	 * @param address3
	 *            the new address 3
	 */
	public void setAddress3(List<Address> address3) {
		this.address3 = address3;
	}

}
