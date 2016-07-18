package com.accolite.anot.reft;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// TODO: Auto-generated Javadoc
/**
 * The Interface DefaultValue.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {

	/**
	 * City.
	 *
	 * @return the string
	 */
	String City() default  "Bangalore";
	
	/**
	 * State.
	 *
	 * @return the string
	 */
	String State() default "Karnataka";
	
	/**
	 * Country.
	 *
	 * @return the string
	 */
	String Country() default "India";
	
}
