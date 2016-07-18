
import java.lang.reflect.Field;
import java.lang.annotation.*;

public class ObjectHandler {

	public Object createObject(String className) {

		Object obj = null;
		try {
			Class myclass = Class.forName(className);
			obj = myclass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void setValue(Object object, String proprertyName, String value) {
		if (proprertyName.equals("city"))
			((Employee) object).setCity(value);
		if (proprertyName.equals("state"))
			((Employee) object).setState(value);
		if (proprertyName.equals("country"))
			((Employee) object).setCountry(value);
		if (proprertyName.equals("name"))
			((Employee) object).setName(value);

	}

	public void setValue(Object object, String proprertyName, int value) {

		if (proprertyName.equals("age"))
			((Employee) object).setAge(value);
	}

	public String getStringValue(Object object, String proprertyName) {
		if (proprertyName.equals("city"))
			return ((Employee) object).getCity();
		if (proprertyName.equals("state"))
			return ((Employee) object).getState();
		if (proprertyName.equals("country"))
			return ((Employee) object).getCountry();
		if (proprertyName.equals("name"))
			return ((Employee) object).getName();
		else
			return null;
	}

	public int getIntValue(Object object, String proprertyName) {

		if (proprertyName.equals("age"))
			return ((Employee) object).getAge();
		else
			return 0;
	}

	public void setDefaultValues(Object object) {
		Class myClass = object.getClass();
		Annotation anno = myClass.getAnnotation(DefaultValue.class);
		for (Field field : myClass.getDeclaredFields()) {
			if (anno != null) {
				if (field.getName().equals("city"))
					setValue(object, "city", ((DefaultValue) anno).City());
				else if (field.getName().equals("state"))
					setValue(object, "state", ((DefaultValue) anno).State());
				else if (field.getName().equals("country"))
					setValue(object, "country", ((DefaultValue) anno).Country());
			}
		}
	}

}
