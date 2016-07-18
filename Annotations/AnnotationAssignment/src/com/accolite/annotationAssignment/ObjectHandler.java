/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package com.accolite.annotationAssignment;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectHandler.
 */
public class ObjectHandler {
	
	/** The my class. */
	Class<?> myClass;
	
	/** The my object. */
	Object myObject;
	
	/** The my field. */
	Field myField;
	
	/**
	 * The Interface DefaultValue.
	 */
	@Retention(RetentionPolicy.RUNTIME)   
	public @interface DefaultValue{
		
		/**
		 * City.
		 *
		 * @return the string
		 */
		String city() default "Bangalore";
		
		/**
		 * State.
		 *
		 * @return the string
		 */
		String state() default "Karnataka";
		
		/**
		 * Country.
		 *
		 * @return the string
		 */
		String country() default "India";
		
	}
	
	/**
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
		
		//Class  myObject = className.class;
		
		myClass= Class.forName(className);
		myObject = myClass.newInstance();
		setDefaultValues(myObject);
		//setDefaultValues(myObject);
		return myObject;	
		
		
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
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		myField.set(object, value);			          			
		
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
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		myField.set(object, value);	
		
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
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		String valueString=(String) myField.get(object);
		return valueString;
		
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
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		int valueInt=(int) myField.get(object);
		return valueInt;
				
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
		
		Annotation[] annotations = object.getClass().getAnnotations();
		for(Annotation annotation : annotations){		
			if(annotation instanceof DefaultValue){ 			 
				DefaultValue test = (DefaultValue) annotation; 			
				setValue(object, "city", test.city());
				setValue(object, "state", test.state());
				setValue(object, "country", test.country());
				
		 		
			} 	
		}
		
	}

}
