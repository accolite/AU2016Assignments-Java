package com.au.java6;

import java.lang.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ObjectHandler {

	
	public Object createObject(String className) {
		Object object=null;
		try{
		 Class clas = Class.forName(className);
		 object = clas.newInstance();
		 setDefaultValues(object);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return object;
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		try {
            Field field = object.getClass().getDeclaredField(proprertyName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
	}
	
	public void setValue(Object object,String proprertyName, int value)  {
		 try {
	            Field field = object.getClass().getDeclaredField(proprertyName);
	            field.setAccessible(true);
	            field.set(object, value);
	        } catch (NoSuchFieldException e) {
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	}
	
	public String getStringValue(Object object, String proprertyName){
		try{
			 Field field = object.getClass().getDeclaredField(proprertyName);    
			  field.setAccessible(true);
			  Object value = field.get(object);
			  return (String)value;
			}
			catch (NoSuchFieldException e) {
				return "";
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	}
	
	public int getIntValue(Object object,String proprertyName) {
		try{
		 Field field = object.getClass().getDeclaredField(proprertyName);    
		  field.setAccessible(true);
		  Integer value = field.getInt(object);
		  return value;
		}
		catch (NoSuchFieldException e) {
			return 0;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
	}
	
	public void setDefaultValues(Object object)  {
		Class myObject = object.getClass();
		Field city,state,country;
		Annotation[] annotations = myObject.getAnnotations();
		//Field[] fields = object.getClass().getFields();
		for(Annotation annotation : annotations){
			//System.out.println( annotation.getClass());
			if(annotation instanceof DefaultValue){ 
				 DefaultValue test = (DefaultValue) annotation;
			setValue(object, "city", test.city());
			setValue(object, "state", test.state());
			setValue(object, "country", test.country());
		}
	}
}
}
