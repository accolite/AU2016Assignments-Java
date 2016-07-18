package com.accolite.AnnotationAssignment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
String city = "Bangalore";
String State = "Karnataka";
String country = "India";
}
