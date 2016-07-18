package com.accolite.anot.reft;
import java.lang.reflect.Field;
import java.lang.annotation.*;
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
		Class<?> myObj = Class.forName(className);
		Object obj = myObj.newInstance();
		return obj;
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
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
			
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
		
			Field field	 = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
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
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			String temp = (String) field.get(object);
			return temp;
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
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);	
			int j = field.getInt(object);
			return j;
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
		Annotation annotation =  object.getClass().getAnnotation(DefaultValue.class);
		DefaultValue temp = (DefaultValue)annotation;
		setValue(object,"city",temp.City());
		setValue(object,"state",temp.State());
		setValue(object,"country",temp.Country());
	}
}
