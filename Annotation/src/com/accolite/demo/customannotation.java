package com.accolite.demo;

import java.lang.annotation.*;  
import java.lang.reflect.*;  

@Retention(RetentionPolicy.RUNTIME)  
//@Target(ElementType.METHOD)  
 public @interface customannotation {


	
	 String city() default "bangalore";
	
	 String state() default "karnataka";
	
	 String country() default "india ";
	
}
