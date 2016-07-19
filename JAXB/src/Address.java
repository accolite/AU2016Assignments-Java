/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Ankush Dhama

* ***************************************************************************

*/
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Address {
	private int hno;
	private int streetno;
	Name name;

	/**
	 * Instantiates a new address.
	 */
	Address(){}
	
	Address(int hno,int streetno,Name name) {
		this.hno=hno;
		this.streetno=streetno;
		this.name=name;
	}
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public int getStreetno() {
		return streetno;
	}

	public void setStreetno(int streetno) {
		this.streetno = streetno;
	}
	
}
