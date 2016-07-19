/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectHandler.
 */
public class ObjectHandler {
	
	/**
	 * Creates the reflection object.
	 *
	 * @param className the class name
	 * @return the reflection object 
	 * @throws ClassNotFoundException the class not found exception
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public Object createObject(String className)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class reflection = Class.forName(className);
		Constructor constructor = reflection.getConstructor(null); //getting constructor method
		Object myObject = constructor.newInstance(); //creating the object instance
		return myObject; 
	}

	/**
	 * Sets the value.
	 *
	 * @param object the reflection object
	 * @param propertyName the property name
	 * @param value the value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchFieldException 
	 */
	public void setValue(Object object, String propertyName, String value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Field field=object.getClass().getDeclaredField(propertyName); //get the reflected field
		field.setAccessible(true); //set it accessible
		field.set(object, value); //set the value to the field for reflected object
//		Method method;
//		switch (propertyName) {
//		case "city":
//			method = object.getClass().getMethod("setCity", String.class); //gets the method of the reflected class
//			method.invoke(object, value); //invokes the method with reflected object
//			break;
//		case "state":
//			method = object.getClass().getMethod("setState", String.class);
//			method.invoke(object, value);
//			break;
//		case "country":
//			method = object.getClass().getMethod("setCountry", String.class);
//			method.invoke(object, value);
//			break;
//		case "name":
//			method = object.getClass().getMethod("setName", String.class);
//			method.invoke(object, value);
//			break;
//		case "address1":
//			method = object.getClass().getMethod("setAddress1", String.class);
//			method.invoke(object, value);
//			break;
//		case "address2":
//			method = object.getClass().getMethod("setAddress2", String.class);
//			method.invoke(object, value);
//			break;
//		}
	}

	/**
	 * Sets the value.
	 *
	 * @param object the reflected object
	 * @param propertyName the property name
	 * @param value the value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchFieldException 
	 */
	public void setValue(Object object, String propertyName, int value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Field field=object.getClass().getDeclaredField(propertyName); //get the reflected field
		field.setAccessible(true); //set it accessible
		field.set(object, value); //set the value to the field for reflected object
//		switch (propertyName) {
//		case "age":
//			Method method = object.getClass().getMethod("setAge", int.class); //gets the method of the reflected class
//			method.invoke(object, value); //invokes the method with reflected object
//			break;
//		}
	}

	/**
	 * Gets the string value.
	 *
	 * @param object the reflected object
	 * @param propertyName the property name
	 * @return the string value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchFieldException 
	 */
	public String getStringValue(Object object, String propertyName) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Field field=object.getClass().getDeclaredField(propertyName); //get the reflected field
		field.setAccessible(true); //set it accessible
		return (String)field.get(object); //returns the value in the filed of the reflected object
//		String result = "";
//		Method method;
//		switch (propertyName) {
//		case "city":
//			method = object.getClass().getMethod("getCity"); //gets the method of the reflected class
//			result = (String) method.invoke(object); //invokes the method with reflected object
//			break;
//		case "state":
//			method = object.getClass().getMethod("getState");
//			result = (String) method.invoke(object, null);
//			break;
//		case "country":
//			method = object.getClass().getMethod("getCountry");
//			result = (String) method.invoke(object, null);
//			break;
//		case "name":
//			method = object.getClass().getMethod("getName");
//			result = (String) method.invoke(object, null);
//			break;
//		case "address1":
//			method = object.getClass().getMethod("getAddress1");
//			result = (String) method.invoke(object, null);
//			break;
//		case "address2":
//			method = object.getClass().getMethod("getAddress2");
//			result = (String) method.invoke(object, null);
//			break;
//		}
//		return result;
	}

	/**
	 * Gets the int value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the int value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchFieldException 
	 */
	public int getIntValue(Object object, String propertyName) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Field field=object.getClass().getDeclaredField(propertyName); //get the reflected field
		field.setAccessible(true); //set it accessible
		return field.getInt(object); //returns the value in the filed of the reflected object
//		Method method;
//		int result = -1;
//		switch (proprertyName) {
//		case "age":
//			method = object.getClass().getMethod("getAge");
//			result = (int) method.invoke(object, null);
//			break;
//		}
//		return result;
	}

	/**
	 * Sets the default values.
	 *
	 * @param object the new default values
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws NoSuchFieldException 
	 */
	public void setDefaultValues(Object object) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Annotation[] annotations = object.getClass().getAnnotations(); //get annotations of the the reflected class
		for (Annotation annotation : annotations) { //loop through the array of  annotations
			if (annotation instanceof DefaultValue) { // if the annotation is DefaultValue then go and set the default values
				DefaultValue defaultValue = (DefaultValue) annotation; //casting Annotation to DefaultValue
				setValue(object, "city", defaultValue.city()); //sets city with the value from DefualtValues
				setValue(object, "state", defaultValue.state()); //sets state with the value from DefualtValues
				setValue(object, "country", defaultValue.country()); //sets country with the value from DefualtValues
			}
		}
	}
}
