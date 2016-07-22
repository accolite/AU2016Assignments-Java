/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Assignment;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class ObjectHandler {

	
	/**
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 */
	public Object createObject(String className) {
		try {
			Class myObject= Class.forName(className);
			Employee e=(Employee)myObject.newInstance();
			setDefaultValues(e);
			return e;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Object();
	}
	
	public void setValue(Object object, String proprertyName, String value) {
		try {
			Field f=object.getClass().getDeclaredField(proprertyName);
			f.setAccessible(true);
			f.set(object,value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setValue(Object object,String proprertyName, int value)  {
		try {
			Field f=object.getClass().getDeclaredField(proprertyName);
			f.setAccessible(true);
			f.setInt(object,value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringValue(Object object, String proprertyName){
		String s=null;
		try {
			Field f=object.getClass().getDeclaredField(proprertyName);
			f.setAccessible(true);
			s=(String)f.get(object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public int getIntValue(Object object,String proprertyName) {
		int n=-1;
		try {
			Field f=object.getClass().getDeclaredField(proprertyName);
			f.setAccessible(true);
			n=(int)f.get(object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	public void setDefaultValues(Object object)  {
		Class c=object.getClass(); 
		Annotation[] annotations = c .getAnnotations();
		for(Annotation annotation : annotations){
			if(annotation instanceof DefaultValue){
				//System.out.println("hiiii");
				DefaultValue dv = (DefaultValue) annotation;
				((Employee) object).setCountry(dv.country());
				((Employee) object).setState(dv.state());
				((Employee) object).setCity(dv.city());
				//System.out.println("name: " + test.value());
			}
		}
	}
}
