package com.accolite.assignment7;

import java.lang.reflect.Field;

public class ObjectHandler {
	public Object createObject(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		@SuppressWarnings("rawtypes")
		Class employeeClass = null;
		try {
			employeeClass = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Object object = employeeClass.newInstance();
		setDefaultValues(object);
		return object;
	}

	public void setValue(Object object, String proprertyName, String value)
			throws NoSuchFieldException, SecurityException {

		Class employeeClass = null;
		try {
			employeeClass = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field field = employeeClass.getDeclaredField(proprertyName);
		field.setAccessible(true);
		try {
			field.set(object, new String(value));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void setValue(Object object, String proprertyName, int value) {

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

	public String getStringValue(Object object, String proprertyName) throws IllegalArgumentException,
			InstantiationException, NoSuchFieldException, SecurityException, IllegalAccessException {

		Class employeeClass = null;
		String answer = null;
		try {
			employeeClass = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field field = employeeClass.getDeclaredField(proprertyName);
		field.setAccessible(true);
		return (String) field.get(object);
	}

	public int getIntValue(Object object, String proprertyName)
			throws IllegalArgumentException, InstantiationException {

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
		Object getIntValueObject = null;
		try {
			getIntValueObject = field.get(object);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return Integer.parseInt(getIntValueObject.toString());
	}

	public void setDefaultValues(Object object)
			throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		Class employeeClass = Class.forName(object.getClass().getName());
		Field field[] = employeeClass.getDeclaredFields();

		for (Field field1 : field) {
			field1.setAccessible(true);
			if (field1.getName().equals("city"))
				field1.set(object, new String("Hyderabad"));
			else if (field1.getName().equals("state"))
				field1.set(object, new String("Telangana"));
			else if (field1.getName().equals("country"))
				field1.set(object, new String("India"));
			else
				continue;
		}
	}

}
