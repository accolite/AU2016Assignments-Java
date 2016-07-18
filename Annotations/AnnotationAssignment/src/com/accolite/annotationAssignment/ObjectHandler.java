package com.accolite.annotationAssignment;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class ObjectHandler {
	
	Class<?> myClass;
	Object myObject;
	Field myField;
	
	@Retention(RetentionPolicy.RUNTIME)   
	public @interface DefaultValue{
		
		String city() default "Bangalore";
		String state() default "Karnataka";
		String country() default "India";
		
	}
	
	public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
		
		//Class  myObject = className.class;
		
		myClass= Class.forName(className);
		myObject = myClass.newInstance();
		setDefaultValues(myObject);
		//setDefaultValues(myObject);
		return myObject;	
		
		
	}
	
	public void setValue(Object object, String proprertyName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		myField.set(object, value);			          			
		
	}
	
	public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		myField.set(object, value);	
		
	}
	
	public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		String valueString=(String) myField.get(object);
		return valueString;
		
	}
	
	public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		myField=object.getClass().getDeclaredField(proprertyName); 
		myField.setAccessible(true);
		int valueInt=(int) myField.get(object);
		return valueInt;
				
	}
	
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
