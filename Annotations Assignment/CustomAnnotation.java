package com.accolite.assignment7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomAnnotation {
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface DefaultValue{
		 String name();
		 int age();
		 String address1();
		 String address2();
		 String city() default "Bangalore";
		 String state() default "Karnataka";
		 String country() default "India";
	}
}
