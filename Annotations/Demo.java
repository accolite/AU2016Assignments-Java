package com.accolite.AnnotationAssignment;

import java.lang.reflect.Constructor;

public class Demo {
	public static void main(String[] args) {
		try {
			Constructor<Employee> constructor = Employee.class.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employee empObj = Constructor.
		setDefaultValues();
		
	}
	static void setDefaultValues(){
		
	}
}
