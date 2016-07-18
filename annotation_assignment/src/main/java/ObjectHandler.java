import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Mitul Kapoor on 7/18/2016.
 */
public class ObjectHandler {


    public Object createObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> employee = Class.forName(className);
        Employee employee1 = (Employee) employee.newInstance();
        return employee1;
    }

    public void setValue(Object object, String proprertyName, String value) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField(proprertyName);
        field.setAccessible(true);
        field.set(object,value);
    }

    public void setValue(Object object,String proprertyName, int value) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField(proprertyName);
        field.setAccessible(true);
        field.set(object,value);
    }

    public String getStringValue(Object object, String proprertyName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField(proprertyName);
        field.setAccessible(true);
        return (String) field.get(object);

    }

    public int getIntValue(Object object,String proprertyName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = object.getClass();
        Field field = clazz.getDeclaredField(proprertyName);
        field.setAccessible(true);
        return (Integer)field.get(object);
    }

    public void setDefaultValues(Object object) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Annotation[] annotation = object.getClass().getAnnotations();
        for (Annotation annotation1 : annotation) {
            if(annotation1 instanceof DefaultValue){
                DefaultValue test = (DefaultValue) annotation1;
                setValue(object,"city",test.city());
                setValue(object,"state",test.state());
                setValue(object,"country",test.country());

            }
        }
    }


}

