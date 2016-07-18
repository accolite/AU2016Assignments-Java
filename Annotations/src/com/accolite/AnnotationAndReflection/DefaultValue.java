/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.AnnotationAndReflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface DefaultValue.
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
public @interface DefaultValue {
	
	/** The city. */
	String city="Banglore";
	
	/** The state. */
	String state="Karnataka";
	
	/** The country. */
	String country="India";
	
	public String CityName() default city;
	public String StateName() default state;
	public String CountryName() default country;
	
	
}
