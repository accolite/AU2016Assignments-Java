package com.accolite.reflectionsdemo;

import java.lang.reflect.Field;

public class ObjectHandler {
	
public Object createObject(String className) {
	
	@SuppressWarnings("rawtypes")
	
	Class c=null;
	Employee employee=null;
	
	try {
		c = Class.forName("com.accolite.reflectionsdemo.Employee");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Class Not found");
		e.printStackTrace();
	} 
	
	 try {
		employee=(Employee)c.newInstance();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 setDefaultValues(employee);
	 return employee;
}
	 
	
	public void setValue(Object object, String proprertyName, String value) {
		
		@SuppressWarnings("rawtypes")
		Class employeeClass = null;
		
		try {
		   employeeClass = Class.forName(object.getClass().getName());
	    } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  }
		
		  Field field = null;
		  
		  try {
		    field = employeeClass.getDeclaredField(proprertyName);
		  } catch (NoSuchFieldException | SecurityException e) {
		   e.printStackTrace();
		  }
		  
		  field.setAccessible(true);
		  
		  try {
		   field.set(object, new String(value));
		  } catch (IllegalArgumentException | IllegalAccessException e) {
		   e.printStackTrace();
		  }
	 }

	
	public void setValue(Object object,String proprertyName, int value)  {
		
		 @SuppressWarnings("rawtypes")
		 Class employeeClass = null;
		 
		 try {
		   employeeClass = Class.forName(object.getClass().getName());
		 } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		 }
		 
		 Field field = null;
		 try {
		    field = employeeClass.getDeclaredField(proprertyName);
		 } catch (NoSuchFieldException | SecurityException e) {
		   e.printStackTrace();
		 }
		 
		 field.setAccessible(true);
		 try {
		   field.set(object, new Integer(value));
		 } catch (IllegalArgumentException | IllegalAccessException e) {
		   e.printStackTrace();
		 }
	}
	
	public String getStringValue(Object object, String proprertyName) throws IllegalArgumentException, IllegalAccessException{
		
		@SuppressWarnings("rawtypes")
		Class employeeClass = null;
		
		try {
		   employeeClass = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();
		}
		 
		Field field = null;
		try {
		    field = employeeClass.getDeclaredField(proprertyName);
		} catch (NoSuchFieldException | SecurityException e) {
		   e.printStackTrace();
		}
		
		field.setAccessible(true);
		return (String) field.get(object);
		  
	}
	
	public int getIntValue(Object object,String proprertyName) throws IllegalArgumentException, IllegalAccessException {
		@SuppressWarnings("rawtypes")
		Class employeeClass = null;
		
		try {
		   employeeClass = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  }
		
		Field field = null;
		
		try {
		    field = employeeClass.getDeclaredField(proprertyName);
		  } catch (NoSuchFieldException | SecurityException e) {
		   e.printStackTrace();
		  }
		
		field.setAccessible(true);
		return (Integer) field.get(object);
				
	}
	
	public void setDefaultValues(Object object)  {
		
		Field[] fields = object.getClass().getDeclaredFields();
		
        for(Field f:fields){
            if(!f.isAccessible()){
                f.setAccessible(true);
                String type = f.getName();
                try{
                	if(type.equals("city")){
                		f.set(object, "Hyderabad");   //Setting Default value
                	}else if(type.equals("state")){
                		f.set(object, "Telangana");
                	}else if (type.equals("country"))
                	{
                		f.set(object, "India");
                	}
                }catch(Exception e)
                {
                	e.printStackTrace();
                }
                }
                f.setAccessible(false);
            }
        }
	}

