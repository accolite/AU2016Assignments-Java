/****************************************************************************
 * Copyright (c) 2016 by Accolite.com. All rights reserved
 *
 * Created date :: Jul 18, 2016
 *
 *  @author :: Sharukh Mohamed
 * ***************************************************************************
 */
package com.accolite.assignmentreflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * The Class ObjectHandler.
 */
public class ObjectHandler {



	/**
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 */
	public Object createObject(String className) {
		Object obj=null;
		try {
			obj = Class.forName(className).newInstance();
			setDefaultValues(obj);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;

	}

	/**
	 * Sets the value for propertyname in the object
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 */
	public void setValue(Object object, String proprertyName, String value) {
		try {
			/**
			 * Access the private field propertyname with string type
			 */
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the value for propertyname in the object
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 */
	public void setValue(Object object,String proprertyName, int value)  {
		try {
			/**
			 * Access the private field propertyname with int type
			 */
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the string value of private String field in Object
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the string value
	 */
	public String getStringValue(Object object, String proprertyName){
		String returnVal="";
		try {
			/**
			 * Get String private property
			 */
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			returnVal = (String) field.get(object);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return returnVal;
	}

	/**
	 * Gets the int value of private int field in object
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the int value
	 */
	public int getIntValue(Object object,String proprertyName) {
		int returnVal=0;
		try {
			/**
			 * Get int private property
			 */
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			returnVal = (int) field.get(object);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		return returnVal;

	}

	/**
	 * Sets the default values using Annotations.
	 *
	 * @param object the new default values
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setDefaultValues(Object object)  {
		try {
			/**
			 * Get Annotation with default values
			 */
			Class myClass = object.getClass();
			Annotation annotation = myClass.getAnnotation(Class.forName("com.accolite.assignmentreflection.DefaultValue"));
			DefaultValue defaultValue = (DefaultValue) annotation;
			
			/**
			 * Set default city
			 */
			Field field = myClass.getDeclaredField("city");
			field.setAccessible(true);
			field.set(object, defaultValue.city());

			/**
			 * Set default state
			 */
			field = myClass.getDeclaredField("state");
			field.setAccessible(true);
			field.set(object, defaultValue.state());

			/**
			 * Set default country
			 */
			field = myClass.getDeclaredField("country");
			field.setAccessible(true);
			field.set(object, defaultValue.country());

		} catch (IllegalAccessException | NoSuchFieldException | SecurityException | IllegalArgumentException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


}
