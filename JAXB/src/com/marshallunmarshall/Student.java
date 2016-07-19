/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.marshallunmarshall;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private int rollno;
	private College coll;
	private float cgpa;

	public Student() {
	}

	public Student(int rollno, College coll, float cgpa) {
		super();
		this.rollno = rollno;
		this.coll = coll;
		this.cgpa = cgpa;
	}

	@XmlAttribute
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	@XmlElement
	public College getColl() {
		return coll;
	}

	public void setColl(College coll) {
		this.coll = coll;
	}

	/**
	 * Gets the cgpa.
	 *
	 * @return the cgpa
	 */
	@XmlElement
	public float getCGPA() {
		return this.cgpa;
	}

	public void setCGPA(float cgpa) {
		this.cgpa = cgpa;
	}

}
