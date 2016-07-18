package com.annotationreflection;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
@Retention(RetentionPolicy.RUNTIME)
public @interface  DefaultValue 
{ 
	String city = "Bangalore";
	String state = "Karnataka";
	String country = "India";
}
