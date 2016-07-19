/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 18, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// TODO: Auto-generated Javadoc
@Retention(RetentionPolicy.RUNTIME)
@interface DefaultValue{
     
	
    String city() default "Bangalore";
    String state() default "Karnataka";
    String country() default "India";

}
 
 /**
  * The Class Employee.
  */
 @DefaultValue
public class Employee {

	/** The Name. */
	private 
	String Name;
	
	/** The Age. */
	int Age;
	
	/** The Address 1. */
	String Address1;
	
	/** The Address 2. */
	String Address2;
	
	/** The City. */
	String City;
	
	/** The State. */
	String State;
	
	/** The Country. */
	String Country;
	
	/*@MyAnnot(Name="Sachin", Address1 = "Hey", Address2 = "hey2", Age = 0)
    public void myAnnotationTestMethod(){
         
        try {
            Class<? extends Employee> cls = this.getClass();
            Method mth = cls.getMethod("myAnnotationTestMethod");
            MyAnnot myAnno = mth.getAnnotation(MyAnnot.class);
            System.out.println("key: "+myAnno.state());
            System.out.println("value: "+myAnno.city());
            System.out.println("value: "+myAnno.Name());
            
            
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    public static void main(String a[]){
         
        Employee mat = new Employee();
        mat.myAnnotationTestMethod();
        try {
			Class c=Class.forName("com.accolite.annotations.Employee");
			Method method1 = c.getDeclaredMethod("myAnnotationTestMethod", new Class[]{});  
			Object o = c.newInstance();
			method1.invoke(o);
			System.out.println(o.getClass().getName());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/

	
}
