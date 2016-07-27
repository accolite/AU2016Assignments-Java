package com.au.chatboxspring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.au.chatboxspring.model.User;

@Repository
public class ChatBoxDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User loginDAOImplementation(User user)
	{
		String query="select username,pwd from users  where username='"+user.getUserName()+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>(){
			public User extractData(ResultSet resultSet) throws SQLException
			{
				User user = new User();
				resultSet.next();
				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				return user;
			}
		});	
	}

	public int registerDAOImplementation(User user) {
		String query="insert into users values("+"'"+user.getUserName()+"'"+","+"'"+user.getPassword()+"'"+",'inactive')";
			return jdbcTemplate.update(query);
	}
}
