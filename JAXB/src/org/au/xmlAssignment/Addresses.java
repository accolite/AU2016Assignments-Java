package org.au.xmlAssignment;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Addresses {

	private List<Address> listOFAddresses;

	public Addresses(List<Address> addresses) {
		super();
		this.listOFAddresses = addresses;
	}
	@XmlElement(name = "address")
	public List<Address> getAddresses() {
		return listOFAddresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.listOFAddresses = addresses;
	}

	public Addresses() {
		super();
	}

	
}
