package com.accolite.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.java.Message;
import com.accolite.java.User;

@Repository
public class ChatApplicationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int registerUser(User user)
	{
		String query = "insert into dbo.user(username,password) values "
				+ "('"+user.getUsername()+"','"+user.getPassword()+"')";		
		return jdbcTemplate.update(query);
	}
	
	public int authenticate(User user)
	{
		final User user1=user;
		String query = "select username,password from dbo.user where username = '"+user.getUsername()+"', password='"+user.getPassword()+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				{
					String query = "insert into dbo.activeUsers(username,password) values "
							+ "('"+user1.getUsername()+"','"+user1.getPassword()+"')";		
					return jdbcTemplate.update(query);
				}
					
				
				else
					return 0;
				
			}
		});

	}
	
	public int addMessage(Message message)
	{
		String query = "insert into dbo.message(message,username) values "
				+ "('"+message.getMessage()+"','"+message.getUsername()+"')";		
		return jdbcTemplate.update(query);
	}
	
	public List<Message> getAllMessages()
	{
		String query = "select * from dbo.message";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {

			public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Message> msgLst=new ArrayList<Message>();
				Message message = new Message();
				while (rs.next()){
					message.setMessage(rs.getString("message"));
					message.setUsername(rs.getString("username"));
					msgLst.add(message);
				}
				return msgLst;

			}
		});

	}

	public List<User> getAllActiveUsers()
	{
		String query = "select * from dbo.activeUsers";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> userLst=new ArrayList<User>();
				User user = new User();
				while (rs.next()){
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					userLst.add(user);
				}
				return userLst;

			}
		});

	}
	
}
