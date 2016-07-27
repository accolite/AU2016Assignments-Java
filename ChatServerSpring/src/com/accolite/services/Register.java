package com.accolite.services;
import com.acccolite.dbtemplate.*;
import org.springframework.beans.factory.annotation.Autowired;



public class Register {
	@Autowired
	private JDBCTemplateDao jdbc;

	public Register() {
		super();
	}

	public Register(JDBCTemplateDao jdbc) {
		super();
		this.jdbc = jdbc;
	}
	public int add(String name,String pass)
	{
		return jdbc.addRegisterUser(name, pass);
	}
	
}
