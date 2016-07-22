/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Assignment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.crypto.CipherInputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@DefaultValue
public class Employee {
	
	/** The name. */
	private String name;
	
	/** The age. */
	private int age;
	
	/** The address 1. */
	private String address1;
	
	/** The address 2. */
	private String address2;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/** The country. */
	private String country;
	
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
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Gets the address 1.
	 *
	 * @return the address 1
	 */
	public String getAddress1() {
		return address1;
	}
	
	/**
	 * Sets the address 1.
	 *
	 * @param address1 the new address 1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	/**
	 * Gets the address 2.
	 *
	 * @return the address 2
	 */
	public String getAddress2() {
		return address2;
	}
	
	/**
	 * Sets the address 2.
	 *
	 * @param address2 the new address 2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Hw.
	 */
	private void hw(){
		System.out.println("Hello world");
	}
	
}
