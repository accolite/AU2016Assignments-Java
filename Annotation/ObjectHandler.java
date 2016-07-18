import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.annotation.*;
public class ObjectHandler {

	
	public Object createObject(String className) {
		Object newobject = null;   
		try {
			Class newclass=Class.forName(className);
			newobject= newclass.newInstance();
            setDefaultValues(newobject);		
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newobject;
		      		
	}
	
	public void setValue(Object object, String proprertyName, String value) throws Exception {
		Class c=object.getClass();
		Field f=c.getDeclaredField(proprertyName);
		f.setAccessible(true);
		f.set(object, value);
	}
	
	public void setValue(Object object,String proprertyName, int value) throws Exception  {
		Class c=object.getClass();
		Field f=c.getDeclaredField(proprertyName);
		f.setAccessible(true);
		f.set(object, value);
	}
	
	public String getStringValue(Object object, String proprertyName) throws Exception{
		Class c=object.getClass();
		Field f=c.getDeclaredField(proprertyName);
		f.setAccessible(true);
		String s=(String) f.get(object);
		return s;
	}
	
	public int getIntValue(Object object,String proprertyName) throws Exception{
		Class c=object.getClass();
		Field f=c.getDeclaredField(proprertyName);
		f.setAccessible(true);
		int s=(int) f.get(object);
		return s;
				
	}
	
	public void setDefaultValues(Object object) throws Exception{
		Class c=object.getClass();
		Annotation[] annotations=c.getAnnotations();
		for(Annotation annotation:annotations){
			if(annotation instanceof DefaultValue){
				DefaultValue d=(DefaultValue)annotation;
			    setValue(object,"city",d.city);
			    setValue(object,"state",d.state);
			    setValue(object,"country",d.country);
			}
		}
	}


}
