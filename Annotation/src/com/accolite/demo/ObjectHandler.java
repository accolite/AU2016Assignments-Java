package com.accolite.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectHandler {

 
	public Object createObject(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> c;
		
			c = Class.forName(className);
			Object demo =  c.newInstance();
		  return demo;
		
		
	}
 
 public void setValue(Object object, String proprertyName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
  Field field=object.getClass().getDeclaredField(proprertyName);
  field.setAccessible(true);
  field.set(object, value);
  
 }
 
 public void setValue(Object object,String proprertyName, int value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
  Field field=object.getClass().getDeclaredField(proprertyName);
  field.setAccessible(true);
  field.set(object, value);
 }
 
 public String getStringValue(Object object, String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
  Field field=object.getClass().getDeclaredField(proprertyName);
  field.setAccessible(true);
  String s=(String)field.get(object);
  return s;
  
 }
 
 public int getIntValue(Object object,String proprertyName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
  Field field=object.getClass().getDeclaredField(proprertyName);
  field.setAccessible(true);
  int i=(int)field.get(object);
  return i;
    
 }
 
 public void setDefaultValues(Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
  Annotation[] annotation=object.getClass().getAnnotations();
  for(Annotation annotation2:annotation){
   if(annotation2 instanceof customannotation){
	   customannotation t=(customannotation)annotation2;
    setValue(object, "city", t.city());
    setValue(object, "state", t.state());
    setValue(object, "country", t.country());
   }
  }
 }


}
