package com.accolite.AnnotationAssignment;

public class TestObjectHandler {
	public static void main(String[] args) throws Exception{
		ObjectHandler handler = new ObjectHandler();
		System.out.println(handler==null);
		Object employee = (Employee)handler.createObject(Employee.class.getName());
		System.out.println(employee==null);
		String city = handler.getStringValue(employee, "city");
		System.out.println("City : " + city);
		String state = handler.getStringValue(employee, "state");
		System.out.println("State : " + state);
		String country = handler.getStringValue(employee, "country");
		System.out.println("Country : " +country);

		handler.setValue(employee, "name", "Sunita");
		String value = handler.getStringValue(employee, "name");
		System.out.println("Name : " + value);
		handler.setValue(employee, "age", 16);
		int intValue = handler.getIntValue(employee, "age");
		System.out.println("Age : "+intValue);
		handler.setDefaultValues(employee);
		System.out.println("city: "+handler.getStringValue(employee, "city"));
	}
}
