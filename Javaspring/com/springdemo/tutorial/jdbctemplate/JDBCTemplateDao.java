package com.springdemo.tutorial.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springdemo.tutorial.controller.*;
import com.springdemo.tutorial.jdbctemplate.*;

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int registerUser(Users user)
	{
		String query = "insert into Users values "
				+ "('"+user.getUsr()+"','"+user.getPwd()+"','"+user.getStatus()+"')";		
		return jdbcTemplate.update(query);
	}
	
	 public int saveMessage(Message message){
		  String query = "insert into messages values "
		    + "("+ message.getMid() +",'"+ message.getMsg() +"')";  
		  return jdbcTemplate.update(query);
		 }
	 
	 public Users getUserDetails(Users user){
		 String query="select usr,pwd from users  where username="+user.getUsr();
		  return jdbcTemplate.query(query, new ResultSetExtractor<Users>(){
		   public Users extractData(ResultSet rs) throws SQLException
		   {
		    Users user = new Users();
		    rs.next();
		    user.setUsr(rs.getString(1));
		    user.setPwd(rs.getString(2));
		    return user;
		   }
		  });
		}
	 
	 
	
	
	
	
} 
