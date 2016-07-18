import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Mitul Kapoor on 7/18/2016.
 */


@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
    public String city() default "Banglore";
    public String state() default "Karnataka";
    public String country() default "India";

}
