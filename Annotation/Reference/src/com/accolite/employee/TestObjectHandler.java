/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.employee;

// TODO: Auto-generated Javadoc
/**
 * The Class TestObjectHandler to test the ObjectHandler.
 */
public class TestObjectHandler {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		ObjectHandler handler = new ObjectHandler(); //object which will be used to create the Reflection and handle the reflection
		Object employee = handler.createObject(Employee.class.getName()); //the Reference object
		handler.setDefaultValues(employee); //sets default values
		String city = handler.getStringValue(employee, "city"); //gets the value of the city in the reflection object 'employee'
		System.out.println("City : " + city);
		String state = handler.getStringValue(employee, "state"); //gets the value of the state in the reflection object 'employee'
		System.out.println("State : " + state);
		String country = handler.getStringValue(employee, "country"); //gets the value of the country in the reflection object 'employee'
		System.out.println("Country : " + country);

		handler.setValue(employee, "name", "Sunita"); //sets name of the reflection object 'employee'
		String value = handler.getStringValue(employee, "name"); //gets value of the name in the reflection object 'employee'
		System.out.println("Name : " + value);
		handler.setValue(employee, "age", 16); //sets name of the reflection object 'employee'
		int intValue = handler.getIntValue(employee, "age"); //gets value of the name in the reflection object 'employee'
		System.out.println("Age : " + intValue);
	}
}
