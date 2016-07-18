/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/

package com.accolite.AnnotationAndReflection;

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
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Object createObject(String className) throws ClassNotFoundException {
		Class employee=Class.forName(className);
		Constructor constructor;
		Object object = null;
		try {
			constructor = employee.getConstructor();
			object = constructor.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}//MyObject.class.getConstructor(String.class);
		
		setDefaultValues(object);
		return object;

	}
	
	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 */
	public void setValue(Object object, String proprertyName, String value) {
		Method method;
		if(proprertyName.equals("name")){    //setting the values for Name
		try {
			 method = object.getClass().getDeclaredMethod("setName",String.class);
			 method.invoke(object,value);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(proprertyName.equals("city")){   //setting the values for City
		try {
			 method = object.getClass().getDeclaredMethod("setCity",String.class);
			 method.invoke(object,value);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(proprertyName.equals("state")){   //setting the values for State
		try {
			 method = object.getClass().getDeclaredMethod("setState",String.class);
			 method.invoke(object,value);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(proprertyName.equals("country")){   //setting the values for Country
		try {
			 method = object.getClass().getDeclaredMethod("setCountry",String.class);
			 method.invoke(object,value);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	/**
	 * Sets the value for Age
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 */
	public void setValue(Object object,String proprertyName, int value)  {
		Method method;
		if(proprertyName.equals("age")){
		try {
			 method = object.getClass().getMethod("setAge",int.class);
			method.invoke(object,value);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	/**
	 * Gets the string value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the string value
	 */
	public String getStringValue(Object object, String proprertyName){
		//Method method = object.class.getMethod("testMethod", String.class); 
		//Object obj = method.invoke(myObject, "parameter-value1");
		Method method;
		if(proprertyName.equals("city")){    //gets city
		try {
			 method = object.getClass().getDeclaredMethod("getCity");
			 method.setAccessible(true);
				return (String) method.invoke(object,null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(proprertyName.equals("state")){   //gets state
 			try {
				 method = object.getClass().getDeclaredMethod("getState");
				 method.setAccessible(true);
					return (String) method.invoke(object,null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		else if(proprertyName.equals("country")){  //gets country
			try {
				 method = object.getClass().getDeclaredMethod("getCountry");
				 method.setAccessible(true);
					return (String) method.invoke(object,null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else if(proprertyName.equals("name")){   //gets name
			try {
				 method = object.getClass().getDeclaredMethod("getName");
				 method.setAccessible(true);
					return (String) method.invoke(object,null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	
	/**
	 * Gets the age.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the int value
	 */
	public int getIntValue(Object object,String proprertyName) {
		Method method;
		if(proprertyName.equals("age")){
		try {
			 method = object.getClass().getMethod("getAge");
				return (int) method.invoke(object,null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		return -1;
	}
	
	/**
	 * Sets the default values for city,state,country.
	 *
	 * @param object the new default values
	 */
	public void setDefaultValues(Object object)  {
		Class  myobject = object.getClass();
		Annotation[] annotations = myobject.getAnnotations();
		for(Annotation annotation : annotations){ 
			if(annotation instanceof DefaultValue){ 
				 DefaultValue values = (DefaultValue) annotation; 
				 Field city,state,country;
				 setValue(object,"city",values.CityName());
				 setValue(object,"state",values.StateName());
				 setValue(object,"country",values.CountryName());
				 
			} 
		}
		
	}


}
			
			

