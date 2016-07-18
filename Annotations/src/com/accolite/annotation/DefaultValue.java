/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: SaiCharan Movva

* ***************************************************************************

*/
package com.accolite.annotation;

import java.lang.annotation.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface DefaultValue.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
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