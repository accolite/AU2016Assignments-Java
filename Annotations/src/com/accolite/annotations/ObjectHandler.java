package com.accolite.annotations;


import java.lang.annotation.Annotation;

public class ObjectHandler {

	 
	 public Object createObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	  
	  Class myObject1= Class.forName(className);
	  return myObject1.newInstance();
	  
	 }
	 
	 public void setValue(Object object, String proprertyName, String value) {
	  
	 }
	 
	 public void setValue(Object object,String proprertyName, int value)  {
	  
	 }
	 
	 public String getStringValue(Object object, String proprertyName)
	 {
	   Class myobject1 = object.getClass();
	  String res=null;
	  Annotation[] annotations = myobject1 .getAnnotations();
	  for(Annotation annotation : annotations){ 
	   if(annotation instanceof DefaultValue){ 
	    DefaultValue val= (DefaultValue) annotation;
	    if(proprertyName.equals("city"))
	     res=(val.city());
	     if(proprertyName.equals("state"))
	     res=(val.state());
	     if(proprertyName.equals("country"))
	     res=(val.country());
	   }
	  }
	   return res;
	 }
	 
	 public int getIntValue(Object object,String proprertyName)
	 {
	  return 0;
	    
	 }
	 
	 
	 public void setDefaultValues(Object object) 
	 {
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
	 
