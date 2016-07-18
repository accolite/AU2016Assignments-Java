import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultEmployee {

	public String city() default "Bangalore";
	public String state() default "Karnataka";
	public String country() default "India";
	
}
