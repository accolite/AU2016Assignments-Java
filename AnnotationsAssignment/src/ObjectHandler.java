import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectHandler {

	public Object createObject(String className) {

		Object object = null;

		try {
			Class employeeClass = Class.forName(className);
			object = employeeClass.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultValues(object);
		return object;

	}

	public void setValue(Object object, String proprertyName, String value) {
		Field field;
		Class employeeClass = object.getClass();
		try {
			field = employeeClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.set(object, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setValue(Object object, String proprertyName, int value) {
		Field field;
		Class employeeClass = object.getClass();
		try {
			field = employeeClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
			field.setInt(object, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getStringValue(Object object, String proprertyName) {
		Field field;
		Class employeeClass = object.getClass();
		String returnValue = null;
		try {
			field = employeeClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
			returnValue = (String) field.get(object);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public int getIntValue(Object object, String proprertyName) {
		Field field;
		Class employeeClass = object.getClass();
		Integer returnValue = null;
		try {
			field = employeeClass.getDeclaredField(proprertyName);
			field.setAccessible(true);
			returnValue = field.getInt(object);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;

	}

	public void setDefaultValues(Object object)  {
		Class employeeClass = object.getClass();
		Annotation[] annotations = employeeClass.getAnnotations();
		for(Annotation annotation : annotations){ 
			if(annotation instanceof DefaultEmployee){ 
				 DefaultEmployee defaultEmployee = (DefaultEmployee) annotation;	
				 setValue(object, "city", defaultEmployee.city());
				 setValue(object, "state", defaultEmployee.state());
				 setValue(object, "country", defaultEmployee.country());
			}
		}		
	}
}
