package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SetDefaultValues {
	@Retention(RetentionPolicy.RUNTIME)
	public @interface DefaultValue {
	  String City() default "Bangalore";
	  String State() default "Karnataka";
	  String Country() default "India";
	}
}
