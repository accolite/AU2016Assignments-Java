package com.accolite.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;



@Repository
public class TemplateDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User AuthUser(String Uername){
		String query = " use ChatSpring ; SELECT Username ,Pwd FROM dbo.User ";
		
		
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()){
				String usr=rs.getString("Username");
				if(usr.equals(Uername))
				{
					user.setPassword(rs.getString("Pwd"));
					user.setUsername(rs.getString("Username"));
				}
				
				}
				return user;
			}
		});
	}
	
	public int RegUser(User user){
		String query = "use ChatSpring ; insert into dbo.Username(Username,Pwd) values "
				+ "("+user.getUsername()+",'"+user.getPassword()+"')";
		return jdbcTemplate.update(query);
	}	
		
	 public List<Message> getAllMessages() {

		  return jdbcTemplate.query(" use ChatSpring ; select * from dbo.Message", new ResultSetExtractor<List<Message>>() {

		   @Override
		   public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {

		    List<Message> list = new ArrayList<Message>();

		    while (rs.next()) {
		     Message m = new Message();
		     m.setUsername(rs.getString(1));
		     m.setMessage(rs.getString(2));
		     list.add(m);
		    }

		    return list;
		   }
		  });
}
	 public int addMessage(Message msg ) {
		  String query = "use ChatSpring; Insert into dbo.Message(username,message) Values ('" + msg.getUsername() + "','" + msg.getMessage() + "')";
		  return jdbcTemplate.update(query);
		 }
	 
	public int activeUSer(String User)
	{
		 String query = "use ChatSpring; Insert into dbo.Message(Active) Values ( 'Active') where Username =" + User + ")";
		 return jdbcTemplate.update(query);
	}
}
