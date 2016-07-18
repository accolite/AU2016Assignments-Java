/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/

package com.accolite.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectHandler.
 */
public class ObjectHandler {

	/**
	 * Creates the object.
	 *
	 * @param className the class name
	 * @return the object
	 * @throws ClassNotFoundException the class not found exception
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public Object createObject(String className)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class C = null;
		C = Class.forName(className);
		Constructor constructor = C.getConstructor(null);
		Object myObject = (Object) constructor.newInstance();
		return myObject;
	}

	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public void setValue(Object object, String proprertyName, String value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method;
		if (proprertyName == "city") {
			method = object.getClass().getMethod("setCity", String.class);
			method.invoke(object, value);
		} else if (proprertyName == "state") {
			method = object.getClass().getMethod("setState", String.class);
			method.invoke(object, value);
		} else if (proprertyName == "country") {
			method = object.getClass().getMethod("setCountry", String.class);
			method.invoke(object, value);
		} else if (proprertyName == "name") {
			method = object.getClass().getMethod("setName", String.class);
			method.invoke(object, value);
		}
	}

	/**
	 * Sets the value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @param value the value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public void setValue(Object object, String proprertyName, int value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = object.getClass().getMethod("setAge", int.class);
		method.invoke(object, value);
	}

	/**
	 * Gets the string value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the string value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public String getStringValue(Object object, String proprertyName)
			throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String S = null;
		Method mt;
		if (proprertyName == "city") {
			mt = object.getClass().getMethod("getCity");
			S = (String) mt.invoke(object);
		} else if (proprertyName == "state") {
			mt = object.getClass().getMethod("getState");
			S = (String) mt.invoke(object);
		} else if (proprertyName == "country") {
			mt = object.getClass().getMethod("getCountry");
			S = (String) mt.invoke(object);
		} else if (proprertyName == "name") {
			mt = object.getClass().getMethod("getName");
			S = (String) mt.invoke(object);
		} else if (proprertyName == "address1") {
			mt = object.getClass().getMethod("getAddress1");
			S = (String) mt.invoke(object);
		} else if (proprertyName == "address2") {
			mt = object.getClass().getMethod("getAddress2");
			S = (String) mt.invoke(object);
		}
		return S;
	}

	/**
	 * Gets the int value.
	 *
	 * @param object the object
	 * @param proprertyName the proprerty name
	 * @return the int value
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public int getIntValue(Object object, String proprertyName) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int r = 0;
		Method mt = object.getClass().getMethod("getAge");
		r = (int) mt.invoke(object);
		return r;
	}

	/**
	 * Sets the default values.
	 *
	 * @param object the new default values
	 * @throws NoSuchMethodException the no such method exception
	 * @throws SecurityException the security exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	public void setDefaultValues(Object object) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class C = object.getClass();
		Annotation[] annotations = C.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof DefaultValue) {
				DefaultValue test = (DefaultValue) annotation;
				setValue(object, "city", test.city());
				setValue(object, "state", test.state());
				setValue(object, "country", test.country());
			}
		}
	}

}
