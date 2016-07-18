package com.accolite.anno;

public class Implemention {
	
	public static void main()
	{
		Class employee = null;
		try {
			employee = Class.forName("com.accolite.anno.Employee.java");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}	
		 try {
			Employee emp = (Employee)employee.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
		 String s=employee.getName();
		 System.out.println(s);
		 
		 
		
		
	}

}
