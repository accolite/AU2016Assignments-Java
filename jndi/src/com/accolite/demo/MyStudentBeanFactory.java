package com.accolite.demo;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public class MyStudentBeanFactory implements ObjectFactory{

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {
		// TODO Auto-generated method stub
		Student student=new Student();
		Reference ref=(Reference) obj;
		Enumeration addrs=ref.getAll();
		while(addrs.hasMoreElements()){
			RefAddr addr=(RefAddr) addrs.nextElement();
			String stuname=addr.getType();
			String stuvalue=(String) addr.getContent();
			if(stuname.equals("schoolname")){
				student.setSchoolname(stuvalue);
			}else if(stuname.equals("id")){
				try{
					student.setId(Integer.parseInt(stuvalue));
				}catch(NumberFormatException e){
					throw new NamingException("Invalid StudentId value "+ stuvalue);
			}
		   }
		}
		return student;
	}
}

