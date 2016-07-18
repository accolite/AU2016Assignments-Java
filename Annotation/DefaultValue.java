import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DefaultValue {
	String city = "Bangalore";
	String state = "Karnataka";
	String country = "India";
}
