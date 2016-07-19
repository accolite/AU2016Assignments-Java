/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.annotations;

public class TestObjectHandler {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception{
		ObjectHandler handler = new ObjectHandler();
		Object employee = handler.createObject(Employee.class.getName());
		handler.setDefaultValues(employee);
		String city = handler.getStringValue(employee, "City");
		System.out.println("City : " + city);
		String state = handler.getStringValue(employee, "State");
		System.out.println("State : " + state);
		String country = handler.getStringValue(employee, "Country");
		System.out.println("Country : " +country);

		handler.setValue(employee, "Name", "Sunita");
		String value = handler.getStringValue(employee, "Name");
		System.out.println("Name : " + value);
		handler.setValue(employee, "Age", 16);
		int intValue = handler.getIntValue(employee, "Age");
		System.out.println("Age : "+intValue);
	}
}
