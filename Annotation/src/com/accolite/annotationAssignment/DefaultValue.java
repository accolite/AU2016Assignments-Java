package com.accolite.annotationAssignment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {

	String City() default  "Bangalore";
	String State() default "Karnataka";
	String Country() default "India";
	
}
