package com.accolite.ChatSpring;

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

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Boolean validateUser(String Username)
	{
		String query = "SELECT user_name FROM ChatBox.dbo.User where"+ "user_name = "+Username;
		
		return jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				User User = new User();
				if(rs.next()==false)
					return true;
				
				else{
					System.out.println("user already exist");
					return false;
				}
			}
		});
	}
	
	
	
	public int addUser(User user)
	{
		String query;
		if( validateUser(user.getUserName())==true)
				{
			 query ="insert into ChatBox.dbo.User values "+user.getUserName()+",'"+user.getPassword();
			 return jdbcTemplate.update(query);
				}
		else{
			return -1;
		}
		
	}
	
	
	public int addMessages(Messages message)
	{
	String query= "insert into ChatBox.dbo.Messages values "+message.getUsername()+",'"+message.getMessage();
	
	return jdbcTemplate.update(query);
	}
	
	
	public List<Messages> retrieveMessages()
	{
		
		String query = "SELECT * FROM ChatBox.dbo.Messages ";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Messages>>() {
			
			@Override
			public List<Messages> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Messages> lst=new ArrayList<Messages>();
				while (rs.next()){
					Messages m=new Messages();
					m.setUsername(rs.getString(1));
					m.setUsername(rs.getString(2));
				lst.add(m);
				}
				return lst;
			}
		});
	}
	
	public User Login(User user)
	{
		String uname=user.getUserName();
		String pass=user.getPassword();
		String query="SELECT * FROM ChatBox.dbo.User where "+ "user_name = "
		                            +uname; 
	
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User User = new User();
				if(rs.next()==false)
					return user;
				
				else{
					System.out.println("Login Fail");
					return null;
				}
			}
		});
	
	
	}
	
	
	
}
/*	public User getUser(Integer id){
		String query = "SELECT User_ID,User_NAME FROM User where"
				+ " User_ID = "+id;
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User User = new User();
				while (rs.next()){
				
				User.setUserId(rs.getInt("User_ID"));
				User.setUserName(rs.getString("User_NAME"));
				}
				return User;
			}
		});
	}
	
	public int saveUser(User User){
		String query = "insert into User(User_ID,User_NAME) values "
				+ "("+User.getUserId()+",'"+User.getUserName()+"')";		
		return jdbcTemplate.update(query);
	}
	
	public Boolean saveUserUsingPreparedStatement(final User User){
		String query = "insert into User(User_ID,User_NAME) values (?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(1, User.getUserId());
				ps.setString(2, User.getUserName());
				return ps.execute();
			}
		});
	}
	
}
s*/