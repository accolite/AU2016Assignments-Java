package com.accolite.annotationAssignment;
import java.lang.reflect.Field;
import java.lang.annotation.*;
public class ObjectHandler {

public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> temp = Class.forName(className);
		
		Object ret = temp.newInstance();
		return ret;
	}
	
	public void setValue(Object object, String proprertyName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
			Field field = object.getClass().getDeclaredField(proprertyName);
			
			field.setAccessible(true);
			
			field.set(object, value);
			
	}
	
	public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		
			Field field	 = object.getClass().getDeclaredField(proprertyName);
			
			field.setAccessible(true);
			
			field.set(object, value);
	}
	
	public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
			Field field = object.getClass().getDeclaredField(proprertyName);
			
			field.setAccessible(true);
			
			String temp1 = (String) field.get(object);
			return temp1;
	}
	
	public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
			Field field = object.getClass().getDeclaredField(proprertyName);
			field.setAccessible(true);	
			
			int temp = field.getInt(object);
			return temp;
	}
	
	public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Annotation annt =  object.getClass().getAnnotation(DefaultValue.class);
		DefaultValue temp = (DefaultValue)annt;
		
		setValue(object,"city",temp.City());
		setValue(object,"state",temp.State());
		setValue(object,"country",temp.Country());
	}
}
