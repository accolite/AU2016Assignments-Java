package Employee;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class Annotation1 {
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Default { 
		String city();
		String state();
		String country();

		
 }
 
@Default ( 
		city="bangalore",
		country="india",
		state="karnataka"
		)
public Annotation1() {
			// TODO Auto-generated constructor stub
		}
}
