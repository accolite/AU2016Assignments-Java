/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 18, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.employee;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface DefaultValue.
 * Annotation for employee class
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE}) 
public @interface DefaultValue {
	
	/**
	 * City.
	 *
	 * @return the string
	 */
	String city() default "Bangalore";
	
	/**
	 * State.
	 *
	 * @return the string
	 */
	String state() default "Karnataka";
	
	/**
	 * Country.
	 *
	 * @return the string
	 */
	String country() default "India"; 
}
