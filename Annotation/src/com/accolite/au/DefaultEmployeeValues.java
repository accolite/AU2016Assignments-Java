package com.accolite.au;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultEmployeeValues {
	String city() default "Bengaluru";
	String state() default "Karnataka";
	String country() default "India";
	
}
