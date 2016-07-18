package com.accolite.Annotations.Assignment;

import java.lang.annotation.Annotation;

public class ObjectHandler {

 
 public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  
  Class myObject= Class.forName(className);
  return myObject.newInstance();
  
 }
 
 public void setValue(Object object, String proprertyName, String value) {
  
 }
 
 public void setValue(Object object,String proprertyName, int value)  {
  
 }
 
 public String getStringValue(Object object, String proprertyName){
   Class myobject1 = object.getClass();
  String result=null;
  Annotation[] annotations = myobject1 .getAnnotations();
  for(Annotation annotation : annotations){ 
   if(annotation instanceof DefaultValue){ 
    DefaultValue check = (DefaultValue) annotation;
    if(proprertyName.equals("city"))
    	result=(check.city());
     if(proprertyName.equals("state"))
    	result=(check.state());
     if(proprertyName.equals("country"))
    	result=(check.country());
   }
  }
   return result;
 }
 
 public int getIntValue(Object object,String proprertyName) {
  return 0;
    
 }
 
 
 public void setDefaultValues(Object object)  {
	 System.out.println("in default");
  Class myobject = object.getClass();
  Annotation[] annotations = myobject .getAnnotations();
  for(Annotation annotation : annotations){ 
   if(annotation instanceof DefaultValue){ 
    DefaultValue test = (DefaultValue) annotation;
     System.out.println("city: " + test.city());
     System.out.println("state: " + test.state()); 
     System.out.println("country: " + test.country()); 
   } 
  
 }


}
}