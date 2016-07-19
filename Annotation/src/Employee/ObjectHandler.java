
package Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHandler {

	public Object createObject(String className) throws Exception {
		Class employee = Class.forName(className);
		Constructor constructor;
		Object object = null;

		constructor = employee.getConstructor();
		object = constructor.newInstance();

		setDefaultValues(object);
		return object;

	}

	public void setValue(Object object, String proprertyName, String value) throws Exception {
		Method method;
		if (proprertyName.equals("name")) { 

			method = object.getClass().getDeclaredMethod("setName", String.class);
			method.invoke(object, value);

		} else if (proprertyName.equals("city")) { 
													

			method = object.getClass().getDeclaredMethod("setCity", String.class);
			
			method.invoke(object, value);
		}

		else if (proprertyName.equals("state"))

		{ // setting the values for State

			method = object.getClass().getDeclaredMethod("setState", String.class);
			method.invoke(object, value);

		} else if (proprertyName.equals("country")) { 
														

			method = object.getClass().getDeclaredMethod("setCountry", String.class);
			method.invoke(object, value);

		}

	}

	public void setValue(Object object, String proprertyName, int value) throws Exception {
		Method method;
		if (proprertyName.equals("age")) {

			method = object.getClass().getMethod("setAge", int.class);
			method.invoke(object, value);

		}

	}


	public String getStringValue(Object object, String proprertyName) throws Exception{
		
		Method method;
		if (proprertyName.equals("city")) { // gets city
			try {
				method = object.getClass().getDeclaredMethod("getCity");
				method.setAccessible(true);
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
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (proprertyName.equals("state")) { // gets state
			try {
				method = object.getClass().getDeclaredMethod("getState");
				method.setAccessible(true);
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
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (proprertyName.equals("country")) { // gets country
			try {
				method = object.getClass().getDeclaredMethod("getCountry");
				method.setAccessible(true);
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
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (proprertyName.equals("name")) { // gets name
			
				method = object.getClass().getDeclaredMethod("getName");
				method.setAccessible(true);
				return (String) method.invoke(object, null);
					}
		return null;
	}

	public int getIntValue(Object object, String proprertyName) throws Exception{
		Method method;
		if (proprertyName.equals("age")) {
			
				method = object.getClass().getMethod("getAge");
				return (int) method.invoke(object, null);
		}
		return -1;
	}

	/**
	 * Sets the default values for city,state,country.
	 *
	 * @param object
	 *            the new default values
	 */
	public void setDefaultValues(Object object) throws Exception {
		Class myobject = object.getClass();
		Annotation[] annotations = myobject.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Default) {
				Default values = (Default) annotation;
				Field city, state, country;
				setValue(object, "city", values.city);
				setValue(object, "state", values.state);
				setValue(object, "country", values.country);

			}
		}

	}

}
