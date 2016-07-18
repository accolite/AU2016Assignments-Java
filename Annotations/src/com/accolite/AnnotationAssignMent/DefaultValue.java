package com.accolite.AnnotationAssignMent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DefaultValue {
		
		String setCity() default "Banglore";
		
		String setState() default "Karnataka";
		
		String setCountry() default "India";		
		
}
