/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.assignmentreflection;

/**
 * The Class TestObjectHandler.
 */
public class TestObjectHandler {

	/**
	 * The main driver function
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception{
		ObjectHandler handler = new ObjectHandler();
		Object employee = handler.createObject(Employee.class.getName());
		String city = handler.getStringValue(employee, "city");
		System.out.println("City : " + city);
		String state = handler.getStringValue(employee, "state");
		System.out.println("State : " + state);
		String country = handler.getStringValue(employee, "country");
		System.out.println("Country : " +country);

		handler.setValue(employee, "name", "Sunita");
		String value = handler.getStringValue(employee, "name");
		System.out.println("Name : " + value);
		handler.setValue(employee, "age", 16);
		int intValue = handler.getIntValue(employee, "age");
		System.out.println("Age : "+intValue);
	}

	
}
