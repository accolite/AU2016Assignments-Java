/**
 * Created by Mitul Kapoor on 7/18/2016.
 */
public class TestObjectHandler {

    public static void main(String[] args) throws Exception{
        ObjectHandler handler = new ObjectHandler();
        Object employee = (Employee)handler.createObject(Employee.class.getName());
        handler.setDefaultValues(employee);
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
    }
}

