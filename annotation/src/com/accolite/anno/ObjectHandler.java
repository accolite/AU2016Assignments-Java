package com.accolite.anno;

import java.lang.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectHandler {

	public Object createObject(String className) {
		
		Class employee = null;
		try {
			employee = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}	
		 try {
			Employee emp = (Employee)employee.newInstance();
			 emp.check();
			 return emp;
					 
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
	
     return null;	
		 
		 
		 
		
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		Class class_obj = object.getClass(); 
		try
		{
		Field field = class_obj.getDeclaredField(proprertyName);
         field.setAccessible(true);
         field.set(object, value);
         System.out.println("value of" + proprertyName + " is set");
		}catch (IllegalArgumentException e) {
            System.out.println(e);
         } catch (Exception e) {
        	 System.out.println(e);
         }
		
		
	}
	
	public void setValue(Object object,String proprertyName, int value)  {
		
		Class class_obj = object.getClass(); 
		try
		{
		Field field = class_obj.getDeclaredField(proprertyName);
         field.setAccessible(true);
         field.set(object, value);
         System.out.println("value of" + proprertyName + " is set");
		}catch (NoSuchFieldException e) {
            System.out.println(e);
         } catch (Exception e) {
        	 System.out.println(e);
         }
	}	
	
	public String  getStringValue(Object object, String proprertyName){
		
		Class class_obj = object.getClass(); 
		Field field = null;
		try {
			field = class_obj.getDeclaredField(proprertyName);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
        field.setAccessible(true);
        try {
			//System.out.println("value of " + proprertyName + " " +field.get(object).toString());
		   return field.get(object).toString();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
		return null;
		 
		
	
	
	
	}	
		
	public int getIntValue(Object object,String proprertyName) {
		Class class_obj = object.getClass(); 
		Field field = null;
		try {
			field = class_obj.getDeclaredField(proprertyName);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
        field.setAccessible(true);
        try {
			//System.out.println("value of " + proprertyName + " " +field.getInt(object));
		    return field.getInt(object); 
        } catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
		return 0;
				
	}
	
	public void setDefaultValues(Object object)  {
		Class myobject = object.getClass();
		  Annotation[] annotations = myobject .getAnnotations();
		  for(Annotation annotation : annotations){ 
		   if(annotation instanceof EmployeeDefault){ 
		    EmployeeDefault test = (EmployeeDefault) annotation;
		     System.out.println("city: " + test.city());
		     System.out.println("state: " + test.state()); 
		     System.out.println("country: " + test.country());
		   }
		
	}
	}
	
	public static void main(String[] args)
	{
		ObjectHandler obj =new ObjectHandler();
		Employee obj_emp=(Employee) obj.createObject("com.accolite.anno.Employee");
		Employee e=new Employee();
		e.setAge(21);
		e.setName("juhi");
		obj.setValue(obj_emp, "age", e.getAge());
		obj.setValue(obj_emp, "name", e.getName());
	
		String s=obj.getStringValue(obj_emp, "name");
		int a=obj.getIntValue(obj_emp, "age");
		System.out.println("name " + s );
		System.out.println("age " + a );
		obj.setDefaultValues(e);
		
		
		
		
	}

}
