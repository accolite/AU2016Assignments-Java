package com.accolite.AnnotationAssignMent;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
public class ObjectHandler {

	
	public Object createObject(String className) {
		try {
			Class newClass = Class.forName(className);
			Object object =  newClass.newInstance();
			setDefaultValues(object);
			return object;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		try {
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setValue(Object object,String proprertyName, int value)  {
		try {
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringValue(Object object, String proprertyName){
		try {
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			String value = (String)field.get(object);
			return value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return null;
	}
	
	public int getIntValue(Object object,String proprertyName) {
		try {
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);
			int value = (int)field.get(object);
			return value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return -1;
				
	}
	
	public void setDefaultValues(Object object)  {
		Class c = object.getClass();
		Annotation an = c.getAnnotation(com.accolite.AnnotationAssignMent.DefaultValue.class);
		for(Field field : c.getDeclaredFields()){
			if(an != null){
			if(field.getName().equals("city"))
			{
		      setValue(object,"city",((DefaultValue) an).setCity());
			}
			else if(field.getName().equals("state"))
			{
			      setValue(object,"state",((DefaultValue) an).setState());
			} 
			else if(field.getName().equals("country"))
			{
			      setValue(object,"state",((DefaultValue) an).setState());
			} 
			}
		}
	}
}



