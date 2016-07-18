package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHandler {
public Object createObject(String className) {
	Class  myObject=null;
	try {
		  myObject = Class.forName(className);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Object o=null;
	 try {
		 o =myObject.newInstance();
	} catch (InstantiationException e1) {
		e1.printStackTrace();
	} catch (IllegalAccessException e1) {
		e1.printStackTrace();
	}
	 setDefaultValues(o); 
	return o;
		
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		Class c=object.getClass();
		if(proprertyName.equals("name"))
		 {	try {
			Method method=c.getMethod("setName",String.class);
			try {
				method.invoke(object,value);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (SecurityException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 	}
			
		 }
		else if(proprertyName.equals("address1"))
		{	try {
			Method method=c.getMethod("setAddress1",String.class);
			try {
				method.invoke(object,value);
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		else if(proprertyName.equals("address2"))
		{	try {
			Method method=c.getMethod("setAddress2",String.class);
			try {
				method.invoke(object,value);
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		else if(proprertyName.equals("city"))
		{	try {
			Method method=c.getDeclaredMethod("setCity",String.class);
			try {
				method.invoke(object,value);
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		else if(proprertyName.equals("state"))
		{	try {
			Method method=c.getDeclaredMethod("setState",String.class);
			try {
				method.invoke(object,value);
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		else if(proprertyName.equals("country"))
		{	try {
			Method method=object.getClass().getDeclaredMethod("setCountry",String.class);
			try {
				method.invoke(object,value);
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}	
		
	}
	
	public void setValue(Object object,String proprertyName, int value)  {
		if(proprertyName.equals("age"))
		{	try {
			Method method=object.getClass().getDeclaredMethod("setAge",String.class);
			try {
				method.invoke(object,value);
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
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			 
		}
		
	}
	
	public String getStringValue(Object object, String proprertyName){
		if(proprertyName.equals("name"))
		{
			Method method=null;
			try {
				method = object.getClass().getDeclaredMethod("getName");
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				return (String) method.invoke(object, null);
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
			return null;
		}
		else if(proprertyName.equals("city"))
		{
			Method method;
			try {
				method = object.getClass().getMethod("getCity");
				return (String)method.invoke(object, null);

			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		else if(proprertyName.equals("state"))
		{
			Method method;
			try {
				method = object.getClass().getMethod("getState");
				return (String)method.invoke(object, null);

			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		else if(proprertyName.equals("city"))
		{
			Method method;
			try {
				method = object.getClass().getMethod("getCountry");
				return (String)method.invoke(object, null);
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	
	
		
	}
	
	public int getIntValue(Object object,String proprertyName) {
		if(proprertyName.equals("age"))
		{	Class noparams[] = {};
			
			try {
				Method method = object.getClass().getMethod("getAge",noparams);
			
				return (int)method.invoke(object,noparams);
				} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
					
			
		}			
	}
	
	public void setDefaultValues(Object object)  {
		 
			  Class myobject = object.getClass();
			  Annotation[] annotations = myobject.getAnnotations();
			  for (Annotation annotation : annotations) {
			   if (annotation instanceof SetDefault) {
			    SetDefault values = (SetDefault) annotation;
			    Field city, state, country;
			    setValue(object, "city", values.city);
			    setValue(object, "state", values.state);
			    setValue(object, "country", values.country);

			   }
			  }

			 }
		
	

}
