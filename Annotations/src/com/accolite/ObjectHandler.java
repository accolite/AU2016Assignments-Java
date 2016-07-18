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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.accolite.DefaultValue;


// TODO: Auto-generated Javadoc
/**
 * The Class ObjectHandler.
 */
public class ObjectHandler {


    /**
     * Creates the object.
     *
     * @param className the class name
     * @return the object
     * @throws ClassNotFoundException the class not found exception
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     */
    public Object createObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> employee = Class.forName(className);
        Employee employee1 = (Employee) employee.newInstance();
        return employee1;
    }

    /**
     * Sets the value.
     *
     * @param object the object
     * @param proprertyName the proprerty name
     * @param value the value
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     * @throws NoSuchFieldException the no such field exception
     * @throws NoSuchMethodException the no such method exception
     * @throws InvocationTargetException the invocation target exception
     */
    public void setValue(Object object, String proprertyName, String value) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class emp = object.getClass();
        Field field = emp.getDeclaredField(proprertyName);
        field.setAccessible(true);
        field.set(object,value);
    }

    /**
     * Sets the value.
     *
     * @param object the object
     * @param proprertyName the proprerty name
     * @param value the value
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     * @throws NoSuchMethodException the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchFieldException the no such field exception
     */
    public void setValue(Object object,String proprertyName, int value) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class emp = object.getClass();
        Field field = emp.getDeclaredField(proprertyName);
        field.setAccessible(true);
        field.set(object,value);
    }

    /**
     * Gets the string value.
     *
     * @param object the object
     * @param proprertyName the proprerty name
     * @return the string value
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     * @throws NoSuchMethodException the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws ClassNotFoundException the class not found exception
     * @throws NoSuchFieldException the no such field exception
     */
    public String getStringValue(Object object, String proprertyName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        Class emp = object.getClass();
        Field field = emp.getDeclaredField(proprertyName);
        field.setAccessible(true);
        return (String) field.get(object);

    }

    /**
     * Gets the int value.
     *
     * @param object the object
     * @param proprertyName the proprerty name
     * @return the int value
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     * @throws NoSuchMethodException the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchFieldException the no such field exception
     */
    public int getIntValue(Object object,String proprertyName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class emp = object.getClass();
        Field field = emp.getDeclaredField(proprertyName);
        field.setAccessible(true);
        return (Integer)field.get(object);
    }

    /**
     * Sets the default values.
     *
     * @param object the new default values
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     * @throws NoSuchMethodException the no such method exception
     * @throws NoSuchFieldException the no such field exception
     * @throws InvocationTargetException the invocation target exception
     */
    public void setDefaultValues(Object object) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Annotation[] annotation = object.getClass().getAnnotations();
        for (Annotation annotation1 : annotation) {
            if(annotation1 instanceof DefaultValue){
                DefaultValue test = (DefaultValue) annotation1;
                setValue(object,"city",test.city());
                setValue(object,"state",test.state());
                setValue(object,"country",test.country());
                System.out.println(test.city());

            }
        }
    }


}