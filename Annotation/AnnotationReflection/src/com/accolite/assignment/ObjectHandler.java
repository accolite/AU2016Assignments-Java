/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.assignment;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectHandler.
 */
public class ObjectHandler {

	
	/**
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> myClass=Class.forName(className);
		Object myObject=myClass.newInstance();
		return myObject  ;
		
	}
	
	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public void setValue(Object object, String proprertyName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f=object.getClass().getDeclaredField(proprertyName);
		f.setAccessible(true);
		f.set(object, value);
		
	}
	
	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Field f=object.getClass().getDeclaredField(proprertyName);
		f.setAccessible(true);
		f.set(object, value);
	}
	
	/**
	 * Gets the string value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the string value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field f=object.getClass().getDeclaredField(proprertyName);
		f.setAccessible(true);
		String tString=(String)f.get(object);
		return tString;
		
	}
	
	/**
	 * Gets the int value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the int value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f=object.getClass().getDeclaredField(proprertyName);
		f.setAccessible(true);
		int i=(int)f.get(object);
		return i;
				
	}
	
	/**
	 * Sets the default values.
	 *
	 * @param object the new default values
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Annotation[] annotation=object.getClass().getAnnotations();
		for(Annotation annotation2:annotation){
			if(annotation2 instanceof DefaultValue){
				DefaultValue test=(DefaultValue)annotation2;
				setValue(object, "city", test.city());
				setValue(object, "state", test.state());
				setValue(object, "country", test.country());
			}
		}
	}


}
