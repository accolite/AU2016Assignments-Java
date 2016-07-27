package com.springdemo.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;

@Repository
public class Servicelogic {
	@Autowired
	private JDBCTemplateDao jdbc;
	int login(String uname,String pw){
		System.out.println("login service"+uname+pw);
		//= for sql injection :)
		if(uname==null||uname.equals("")||uname.contains("=")){
			return 0;
		}
		return(jdbc.logincheck(uname, pw));
		//return s;
	}
	int setChats(String uname,String chat){
		int s=jdbc.setChats(uname,chat);
		return s;
	}
	
	String getChats(){
		String s=jdbc.getChats();
		return s;
	}
}
