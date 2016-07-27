package com.au.JdbcTemplate;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class JdbcTemplateDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void register(UserDetails details)
	{
		String query = "insert into RegisterAndLogin(Username,Password) values "
				+ "("+details.getUsername()+",'"+details.getPassword()+"')";		
		jdbcTemplate.update(query);
	}
	
	public UserDetails login(String name)
	{
		String query = "SELECT Username,Password FROM RegisterAndLogin where"
					    + " Username = "+name;
		return jdbcTemplate.query(query, new ResultSetExtractor<UserDetails>(){

		  public UserDetails extractData(ResultSet rs) throws SQLException, DataAccessException
					   {
					    UserDetails user1 = new UserDetails();
					    while (rs.next()){
					     String user=rs.getString("Username");
					     String pass=rs.getString("password");
					     if(user.equals(name))
					     {
					      user1.setUsername(name);
					      user1.setPassword(pass);
					     }
					      return user1;
					    }
					    return null;
					   }
  });
	}
	
	public void insertMessage(Chat message)
	{
		String query = "insert into ChatBox() values "
				+  "("+message.getUsername()+",'"+message.getMessage()+"')";	
		jdbcTemplate.update(query);
	}
	
	public List<Chat> GetChatList()
	{
	 List<Chat> messages=null;
	  String query = "SELECT Username,Message FROM ChatBox ";
	  return jdbcTemplate.query(query, new ResultSetExtractor<List<Chat>>() {

	   public List<Chat> extractData(ResultSet rs) throws SQLException, DataAccessException {
	    Chat chat = new Chat();
	    while (rs.next()){
	     chat.setUsername(rs.getString("Username"));
	     chat.setMessage(rs.getString("message"));
	      messages.add(chat);
	 }
	 return messages;
	 
	}
	  });
	}
	
	
	 public int SetActiveUser(UserDetails user)
	 {
	  String query = "Update RegisterAndLogin SET Active=1 where Username="+user.getUsername();  
	  return jdbcTemplate.update(query);
	 }
	 
	 public int SetInActiveUser(UserDetails user)
	 {
	  String query = "Update RegisterAndLogin SET active=0 where Username="+user.getUsername();  
	  return jdbcTemplate.update(query);
	 }


}
