package com.accolite.assignment;

import java.lang.annotation.Annotation;

public class ObjectHandler {

	public Object createObject(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class myObject = Class.forName(className);
		return myObject.newInstance();

	}

	public void setValue(Object object, String proprertyName, String value) {

	}

	public void setValue(Object object, String proprertyName, int value) {

	}

	@DefaultValue
	public String getStringValue(Object object, String proprertyName) {
		Class myobject = object.getClass();
		String property = null;
		Annotation[] annotations = myobject.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof DefaultValue) {
				DefaultValue test = (DefaultValue) annotation;
				if (proprertyName == "city")
					property = test.city();
				if (proprertyName == "state")
					property = test.state();
				if (proprertyName == "country")
					property = test.country();
			}

		}
		return property;

	}

	public int getIntValue(Object object, String proprertyName) {
		return 0;

	}

	public void setDefaultValues(Object object) {
		Class myobject = object.getClass();
		Annotation[] annotations = myobject.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof DefaultValue) {
				DefaultValue test = (DefaultValue) annotation;
				System.out.println("city: " + test.city());
				System.out.println("state: " + test.state());
				System.out.println("country: " + test.country());
			}

		}

	}
}
