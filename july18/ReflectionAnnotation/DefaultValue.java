/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 18, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.accolite.assignmentreflection;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;


/**
 * The Interface DefaultValue.
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
public @interface DefaultValue {
	String city() default "Bangalore";
	String state() default "Karnataka";
	String country() default "India";
}
