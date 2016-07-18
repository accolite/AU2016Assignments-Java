package Assignment;

import java.lang.reflect.Method;

public class ObjectHandler {

	public static Object setDefaults(Object obj) {
		Employee emp = new Employee();
		try {
			Method m = emp.getClass().getMethod("setDefaultValue");
			DefaultValue dv = m.getAnnotation(DefaultValue.class);
			
			// setting default values using annotation
			emp.setCity(dv.city());
			emp.setState(dv.state());
			emp.setCountry(dv.country());
			
			System.out.println(emp.getCity() + "," + emp.getState() + "," + emp.getCountry());
		}
		catch(Exception e) {}
		return ((Object) emp);
	}
	
	public Object createObject(String className) {
		boolean flag = false;
		Object e = null;
		try {
			   //String className = "com.path.to.ImplementationType";// really passed in from config
			Class c = Class.forName(className);
			e = (Object) c.newInstance();
			if (e.getClass().getName().equalsIgnoreCase("Assignment.Employee")) {
				flag = true;
			} 
		} catch (Exception E) {
			   E.printStackTrace();
		}
		System.out.println("Object created :" + flag);
		e = ObjectHandler.setDefaults(e);
		return e;
	}
	
	public void setValue(Object object, String propertyName, String value) {
		Employee e = (Employee) object;
		if(propertyName.equalsIgnoreCase("address1")) e.setAddress1(value);
		else if(propertyName.equalsIgnoreCase("address2")) e.setAddress2(value);
		else if(propertyName.equalsIgnoreCase("name")) e.setName(value);
		else if(propertyName.equalsIgnoreCase("city")) e.setCity(value);
		else if(propertyName.equalsIgnoreCase("state")) e.setState(value);
		else if(propertyName.equalsIgnoreCase("country")) e.setCountry(value);
		else System.out.println("Invalid property");
	}
	
	public void setValue(Object object,String propertyName, int value)  {
		if(propertyName.equalsIgnoreCase("age")){
			Employee e = (Employee) object;
			e.setAge(value);
		}
	}
	
	public String getStringValue(Object object, String propertyName){
		Employee e = (Employee) object;
		Object returnValue = null;
		String s1 = propertyName.substring(0, 1).toUpperCase();
	    String methodName = "get" + s1 + propertyName.substring(1);
		try {
			Method m = e.getClass().getMethod(methodName);
			//Method method = MyObject.class.getMethod("doSomething", String.class);
			returnValue = m.invoke(e);
			
		}
		catch(Exception E) {}
		return ((String) returnValue);
	}
	
	public int getIntValue(Object object,String propertyName) {
		int retValue = 0;
		if(propertyName.equalsIgnoreCase("age")){
			Employee e = (Employee) object;
			retValue = e.getAge();
		}
		return retValue;
	}
	
	public void setDefaultValues(Object object)  {
		if(object.getClass().getName().equalsIgnoreCase("Assignment.Employee")) {
			Employee emp = (Employee) object;
			try {
				Method m = emp.getClass().getMethod("setDefaultValue");
				DefaultValue dv = m.getAnnotation(DefaultValue.class);
				
				// setting default values using annotation
				emp.setCity(dv.city());
				emp.setState(dv.state());
				emp.setCountry(dv.country());
				
				System.out.println(emp.getCity() + "," + emp.getState() + "," + emp.getCountry());
			}
			catch(Exception e) {}
		}
	}


}

