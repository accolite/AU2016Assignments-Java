package com.accolite.au;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectHandler {

	
	public Object createObject(String className) {
		Object obj = null;
		try {
			Class<?> myClass = Class.forName(className);
			obj = myClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void setValue(Object object, String propertyName, String value) {
		Field field;
		try {
			field = object.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			field.set(object,value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void setValue(Object object,String propertyName, int value)  {
		Field field;
		try {
			field = object.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			field.set(object,value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public String getStringValue(Object object, String propertyName){
		String value = null;
		try {
			Field field = object.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			Object obj = field.get(object);
			if(obj != null)
				value = obj.toString();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public int getIntValue(Object object,String propertyName) {
		int value = 0;
		try {
			Field field = object.getClass().getDeclaredField(propertyName);
			field.setAccessible(true);
			Object obj = field.get(object);
			if(obj != null)
				value = Integer.parseInt(obj.toString());
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	public void setDefaultValues(Object object)  {
		Annotation annotation = object.getClass().getAnnotation(DefaultEmployeeValues.class);
		if(annotation instanceof DefaultEmployeeValues){
			DefaultEmployeeValues defaultValues = (DefaultEmployeeValues)annotation;
		    setValue(object, "city", defaultValues.city());
		    setValue(object, "state", defaultValues.state());
		    setValue(object, "country", defaultValues.country());
		}
	}


}
