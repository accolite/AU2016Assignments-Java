/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package Assignment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface DefaultValue.
 */
@Retention(RetentionPolicy.RUNTIME) //can use in method only.
public @interface DefaultValue {
	
	/**
	 * City.
	 *
	 * @return the string
	 */
	String city() default "Banglore";
	
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
	//should ignore this test?
}