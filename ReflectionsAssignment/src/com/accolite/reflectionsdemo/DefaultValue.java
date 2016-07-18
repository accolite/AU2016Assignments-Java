package com.accolite.reflectionsdemo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

	
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level

public @interface DefaultValue {
		
	String Name();
	int Age();
	String Address1();
	String Address2();
	String City() default "Bangalore";
	String State() default "Karnataka";
	String Country() default "India";

}

