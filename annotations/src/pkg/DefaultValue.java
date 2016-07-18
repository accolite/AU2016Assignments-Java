package pkg;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE)
@interface DefaultValue{
	 String City() default "Bangalore";
	 String State() default "Karnataka";
	 String Country() default "India";

}

