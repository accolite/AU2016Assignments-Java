/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */
package com.accolite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




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
    public String city() default "Banglore";
    
    /**
     * State.
     *
     * @return the string
     */
    public String state() default "Karnataka";
    
    /**
     * Country.
     *
     * @return the string
     */
    public String country() default "India";

}