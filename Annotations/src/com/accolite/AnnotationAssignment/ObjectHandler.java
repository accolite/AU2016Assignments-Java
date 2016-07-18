package com.accolite.AnnotationAssignment;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectHandler {

	public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		 Class myObj = Class.forName(className);
		  Object obj = myObj.newInstance();
		  return obj;
		
	}
	
	public void setValue(Object object, String proprertyName, String value)  throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = object.getClass().getDeclaredField(proprertyName);
		   field.setAccessible(true);
		   field.set(object, value);
		
	}
	
	public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		 Field field  = object.getClass().getDeclaredField(proprertyName);
		   field.setAccessible(true);
		   field.set(object, value);
	}
	
	public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = object.getClass().getDeclaredField(proprertyName);
		   field.setAccessible(true);
		   String temp = (String) field.get(object);
		   return temp;
	}
	
	public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		 Field field = object.getClass().getDeclaredField(proprertyName);
		   field.setAccessible(true); 
		   int j = field.getInt(object);
		   return j;
				
	}
	
	public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Annotation annotation =  object.getClass().getAnnotation(Default1.class);
		Default1 temp = (Default1)annotation;
		  setValue(object,"city",temp.city());
		  setValue(object,"state",temp.state());
		  setValue(object,"country",temp.country());
		
	}
}
