package com.accolite.spring.ChatBoxUsingSpring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	void addUser(UserInfo user)
	{
		String username=user.getUserName();
		String passwordUser=user.getUserPassword();
		String query = "insert into dbo.LoggedInUsers(UserName,Password,online) values ('"+username+"'"+",'"+passwordUser+"','false')";
		jdbcTemplate.update(query);
	}
}
