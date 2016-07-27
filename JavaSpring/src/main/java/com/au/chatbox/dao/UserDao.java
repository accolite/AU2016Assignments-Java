package com.au.chatbox.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.au.chatbox.model.Message;
import com.au.chatbox.model.User;

@Repository
public class UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int registerUser(User user)
	{
		String query = "insert into Users values "
				+ "('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getStatus()+"')";		
		return jdbcTemplate.update(query);
	}
	
	 public int setUserToActive(User user){
		  String query = "update users set status='active' where username='"+user.getUsername()+"'";  
		  return jdbcTemplate.update(query);
		 }
	
	 public int saveMessage(Message message){
		  String query = "insert into messages values "
		    + "("+ message.getUserId() +",'"+ message.getMessage() +"')";  
		  return jdbcTemplate.update(query);
		 }
	 
	 public User getUserDetails(User user){
		 String query="select username,pwd from users  where username="+user.getUsername();
		  return jdbcTemplate.query(query, new ResultSetExtractor<User>(){
		   public User extractData(ResultSet rs) throws SQLException
		   {
		    User user = new User();
		    rs.next();
		    user.setUsername(rs.getString(1));
		    user.setPassword(rs.getString(2));
		    return user;
		   }
		  });
		}
	 
	
	 
	
	
	
}


