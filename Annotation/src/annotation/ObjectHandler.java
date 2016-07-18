package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import annotation.SetDefaultValues.DefaultValue;

public class ObjectHandler {
	
	
public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
	Object object=null;
	try{
		Class myclass = Class.forName(className);
		object=myclass.newInstance();
		setDefaultValues(object);
	} catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	return object;
	
	}
	
	public void setValue(Object object, String proprertyName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field myfield=object.getClass().getDeclaredField(proprertyName);
		myfield.setAccessible(true);
		myfield.set(object, value);
		
	}
	
	public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Field myfield=object.getClass().getDeclaredField(proprertyName);
		myfield.setAccessible(true);
		myfield.setInt(object, value);
		
	}
	
	public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field myfield=object.getClass().getDeclaredField(proprertyName);
		myfield.setAccessible(true);
		String valueString=(String) myfield.get(object);
		return valueString;
	}
	
	public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field myfield=object.getClass().getDeclaredField(proprertyName);
		myfield.setAccessible(true);
		int value=(int) myfield.get(object);
		return value;	
	}
	
	public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		Class employee=object.getClass();
		Annotation[] annotations = employee.getAnnotations();
		for(Annotation annotation : annotations){ 
			if(annotation instanceof DefaultValue){ 
				DefaultValue test = (DefaultValue) annotation;
				setValue(object,"city",test.City());
				setValue(object,"state",test.State());
				setValue(object,"country",test.Country());
				}
		}
	}
}