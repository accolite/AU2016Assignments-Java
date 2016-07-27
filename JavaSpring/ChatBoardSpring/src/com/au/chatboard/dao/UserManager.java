package com.au.chatboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.au.chatboard.bean.User;

@Component
public class UserManager {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addUser(User user){
		String query = "INSERT INTO Users (username, password) values ('"+user.getUsername()+"','"+user.getPassword()+"')";
		return jdbcTemplate.update(query);	
	}
	
	public boolean isExist(String username){
		String query = "SELECT * FROM Users where username = '"+username+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>(){

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
					return true;
				return false;
			}
			
		});	
	}
	
	public boolean checkUser(User user){
		
		String query = "SELECT * FROM Users where username = '"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>(){

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
					return true;
				return false;
			}
			
		});	
	}
}
