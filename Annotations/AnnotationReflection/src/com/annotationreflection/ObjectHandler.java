/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Udit Mehata

* ***************************************************************************

*/
package com.annotationreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectHandler.
 */
public class ObjectHandler 
{
	
	/**
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 * @throws Exception the exception
	 * @throws SecurityException the security exception
	 */
	public Object createObject(String className) throws Exception, SecurityException 
	{
		try 
		{
			Class EmployeeClass = Class.forName( className );
			Object MyObject = EmployeeClass.newInstance();
			return MyObject;
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public void setValue(Object object, String proprertyName, String value) throws NoSuchFieldException, SecurityException 
	{
		 try 
		    {
		    	Class objectClass = object.getClass();
		    	Field propname = objectClass.getDeclaredField(proprertyName);
		    	propname.setAccessible(true);
		    	propname.set(object, value);
			} 
		    catch (IllegalArgumentException e) 
		    {
				e.printStackTrace();
			} 
		    catch (IllegalAccessException e) 
		    {
				e.printStackTrace();
			}
	}
	
	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException  
	{
		try 
	    {
	    	Class objectClass = object.getClass();
	    	Field propname = objectClass.getDeclaredField(proprertyName);
	    	propname.setAccessible(true);
	    	propname.set(object, value);
		} 
	    catch (IllegalArgumentException e) 
	    {
			e.printStackTrace();
		} 
	    catch (IllegalAccessException e) 
	    {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the string value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the string value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException
	{
		 try 
		    {
		    	Class objectClass = object.getClass();
		    	Field propname = objectClass.getDeclaredField(proprertyName);
		    	propname.setAccessible(true);
				return (String) propname.get( object );
			} 
		    catch (IllegalArgumentException e) 
		    {
				e.printStackTrace();
			} 
		    catch (IllegalAccessException e) 
		    {
				e.printStackTrace();
			}
		 	return null;
	}
	
	/**
	 * Gets the int value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the int value
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException 
	{
		try 
	    {
	    	Class objectClass = object.getClass();
	    	Field propname = objectClass.getDeclaredField(proprertyName);
	    	propname.setAccessible(true);
			return ( Integer ) propname.get( object );
		} 
	    catch (IllegalArgumentException e) 
	    {
			e.printStackTrace();
		} 
	    catch (IllegalAccessException e) 
	    {
			e.printStackTrace();
		}
	 	return -1;		
	}
	
	/**
	 * Sets the default values.
	 *
	 * @param object the new default values
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException the security exception
	 */
	public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException 
	{
		Class myObject = object.getClass();
		Annotation[] annotations = myObject.getAnnotations();
		for(Annotation annotation : annotations)
		{ 
			if(annotation instanceof DefaultValue)
			{
				 DefaultValue test = ( DefaultValue ) annotation;
				 setValue( object, "city", test.city); 
				 setValue( object, "state", test.state);
				 setValue( object, "country", test.country);
			}
		}
	}
}
