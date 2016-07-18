package com.au.java6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  
public @interface DefaultValue {
	//@interface DefaultValue{
		String city() default "Bangalore";
		String state() default "Karnataka";
		String country() default "India";
	//}
}
