/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.annotations;
import java.lang.reflect.Field;
import java.lang.annotation.*;
public class ObjectHandler {

public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	 
	  Class<?> clazz = Class.forName(className); 
	  Object obj =clazz.newInstance();
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
	 
	 Class<?> clazz=object.getClass();
	 Field f = clazz.getDeclaredField(proprertyName);
	 f.setAccessible(true);
	 f.set(object, value);
   
 }
 
 public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
  
	 Class<?> clazz=object.getClass();
	 Field f = clazz.getDeclaredField(proprertyName);
	 f.setAccessible(true);
	 f.set(object, value);
 }
 
 public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	
	 Class<?> clazz=object.getClass();
	 Field f = clazz.getDeclaredField(proprertyName);
	 f.setAccessible(true);
	 return (String) f.get(object);
 }
 
 public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	   
	  Class<?> clazz=object.getClass();
	  Field f = clazz.getDeclaredField(proprertyName);
	  f.setAccessible(true); 
	  return f.getInt(object);
 }
 
 public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
	  
	  Class<?> clazz=object.getClass();
	  Annotation a =  clazz.getAnnotation(DefaultValue.class);
	  DefaultValue d = (DefaultValue)a;
	  setValue(object,"City",d.city());
	  setValue(object,"State",d.state());
	  setValue(object,"Country",d.country());
 }
}