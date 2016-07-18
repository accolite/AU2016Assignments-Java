package com.accolite.AnnotationAssignment;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHandler {




	
	public Object createObject(String className) throws Exception{
			Class myClass= Class.forName(className);	
			Constructor<Employee> constructor;
			constructor = myClass.getConstructor();
			Employee empObj = constructor.newInstance();
			return (Object)(constructor.newInstance());
		
		
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		Class myClass = object.getClass();
		System.out.println(object.getClass().getName());
		
		Field field = null;
		try {
			field= myClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			field.set(object, value);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setValue(Object object,String proprertyName, int value)  {
Class myClass = object.getClass();
		
		Field field = null;
		try {
			field= myClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			field.set(object, value);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringValue(Object object, String proprertyName){
		Class myClass = object.getClass();
		//System.out.println(object == null);
		Field field=null;
		Object value=null;
		try {
			field = myClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
			value = field.get(object);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
			// TODO: handle exception
		}
	//	Object value=null;
//		try {
//			value = field.get(object);
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return (String)value;
	}
	
	public int getIntValue(Object object,String proprertyName) {
		Class myClass = object.getClass();
		Field field=null;
		try {
			field = myClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Object value=null;
		try {
			value = field.get(object);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ((Integer)value).intValue();
	}
	
	public void setDefaultValues(Object object)  {
		Class myClass = object.getClass();
		Annotation[] annotations = myClass.getAnnotations();
		for(Annotation annotation : annotations){
			if(annotation instanceof DefaultValue)
			{
				DefaultValue defaultValue = (DefaultValue)annotation; 
				Method method = null;
				try {
					method = myClass.getMethod("setCity", new Class[]{String.class});
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					method.invoke(object, defaultValue.city);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					method = myClass.getMethod("setState", new Class[]{String.class});
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					method.invoke(object, defaultValue.State);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					method = myClass.getMethod("setCountry", new Class[]{String.class});
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					method.invoke(object, defaultValue.country);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


}


