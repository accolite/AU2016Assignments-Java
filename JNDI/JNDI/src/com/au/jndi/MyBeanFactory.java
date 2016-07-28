package com.au.jndi;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class MyBeanFactory implements ObjectFactory{
	@Override
	public Object getObjectInstance(Object obj,Name arg1, Context arg2,
		Hashtable<?,?> arg3) throws Exception{
		Student student = new Student();
		Reference ref = (Reference) obj;
		Enumeration addrs = ref.getAll();
		while(addrs.hasMoreElements()){
			RefAddr addr = (RefAddr) addrs.nextElement();
			String name = addr.getType();
			String value = (String) addr.getContent();
			if(name.equals("school_name")){
				student.setSchool_name(value);
			} else if(name.equals("id")){
				try{
					student.setId(Integer.parseInt(value));
				}catch(NumberFormatException e){
					throw new NamingException("Invalid 'studentid' value "+value);
				}
			}
		}
		return student;
	}
}
