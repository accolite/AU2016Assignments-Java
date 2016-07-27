package com.au.dao;

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

import com.au.controller.Login;



public class ChatBoxDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public Login login(String name,String password){
		String query = "SELECT 'name','password' FROM Login";
		return (Login) jdbcTemplate.query(query, new ResultSetExtractor<Login>() {

			public Login extractData(ResultSet rs) throws SQLException, DataAccessException {
				Login login = new Login();
				while (rs.next()){
				
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));
				}
				return login;
			}
		});
	}
	
	
}
