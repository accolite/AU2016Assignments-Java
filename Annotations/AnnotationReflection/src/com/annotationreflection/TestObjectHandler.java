/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.annotationreflection;

// TODO: Auto-generated Javadoc
/**
 * The Class TestObjectHandler.
 */
public class TestObjectHandler {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception
	{
		ObjectHandler handler = new ObjectHandler();
		Object employee = ( Employee ) handler.createObject(Employee.class.getName());
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
		System.out.println("Age : "+ intValue);
		
		handler.setDefaultValues( employee );
		System.out.println("Replaced Values from Default Annotations ");
		city = handler.getStringValue(employee, "city");
		System.out.println("City : " + city);
		state = handler.getStringValue(employee, "state");
		System.out.println("State : " + state);
		country = handler.getStringValue(employee, "country");
		System.out.println("Country : " +country);
	}
}
