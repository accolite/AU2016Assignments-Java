package pkg;

import java.lang.annotation.*;
import java.lang.reflect.Field;
public class ObjectHandler {

	
	public Object createObject(String className) {
		Object o = null;
		try {
			Class c = Class.forName(className);
			o=  c.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		if(proprertyName.equals("city"))
			((Employee)object).setCity(value);
		if(proprertyName.equals("state"))
			((Employee)object).setState(value);
		if(proprertyName.equals("country"))
			((Employee)object).setCountry(value);
		if(proprertyName.equals("name"))
			((Employee)object).setName(value);
	}
	
	public void setValue(Object object,String proprertyName, int value)  {

		if(proprertyName.equals("age"))
			((Employee)object).setAge(value);
		
	}
	
	public String getStringValue(Object object, String proprertyName){
		if(proprertyName.equals("city"))
			return ((Employee)object).getCity();
		if(proprertyName.equals("state"))
			return ((Employee)object).getState();
		if(proprertyName.equals("country"))
			return ((Employee)object).getCountry();
		if(proprertyName.equals("name"))
			return ((Employee)object).getName();
		else 
			return null;
		
	}
	
	public int getIntValue(Object object,String proprertyName) {

		if(proprertyName.equals("age"))
			return ((Employee)object).getAge();
		else
			return 0;
	}
	
	public void setDefaultValues(Object object)  {
		Class c = object.getClass();
	  Annotation an = c.getAnnotation(pkg.DefaultValue.class);
	  for(Field field : c.getDeclaredFields())
	  {
		   if(an != null)
		   {
			   if(field.getName().equals("city"))
			        setValue(object,"city",((DefaultValue) an).City());
			   else if(field.getName().equals("state"))
			         setValue(object,"state",((DefaultValue) an).State());
			   else if(field.getName().equals("country"))
			         setValue(object,"country",((DefaultValue) an).Country());
		   }
	}
	}
}
