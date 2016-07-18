package com.accolite.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface EmployeeDefault { 
	 String city() default "Bangalore";
	
	 String state() default "Karnataka";
	
	 String country() default "Indian";
}