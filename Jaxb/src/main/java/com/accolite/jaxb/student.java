package com.accolite.jaxb;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

// TODO: Auto-generated Javadoc
/**
 * The Class student.
 */
@XmlRootElement(name = "student")
@XmlAccessorType (XmlAccessType.FIELD)
public class student 
{
	
	/** The rollno. */
	private Integer rollno;
    
    /** The firstname. */
    private String firstname;
    
    /** The lastname. */
    private String lastname;
   
    /** The marks. */
    private Integer marks;
    
	/**
	 * Gets the rollno.
	 *
	 * @return the rollno
	 */
	public Integer getRollno() {
		return rollno;
	}
	
	/**
	 * Sets the rollno.
	 *
	 * @param rollno the new rollno
	 */
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	
	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Gets the marks.
	 *
	 * @return the marks
	 */
	public Integer getMarks() {
		return marks;
	}
	
	/**
	 * Sets the marks.
	 *
	 * @param marks the new marks
	 */
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
     
   
}
