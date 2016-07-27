package com.accolite.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.service.Users;


@Repository
public class JDBCTemplateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public String addUser(Users user){
		
		String query = "insert into users(name,userpassword,userrole,userstatus) values "
				+ "("+user.getName()+",'"+user.getPassword()+",'"+user.getRole()+",'"+user.getStatus()+"')";		
		int result = jdbcTemplate.update(query);
		if(result==0)
			return "failed";
		else
			return "success";
	}
	
	public String checkUser(String name,String password){
		return null;
	}
	
	public String checkAdmin(String name,String password){
		return null;
	}
	
	public void addBannedWords(String words){
		
	}
	
	public void addMessage(String name,String message){
		
	}
	
	public String getMessages(){
		
		return null;
	}
	
}
