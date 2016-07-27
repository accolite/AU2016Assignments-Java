package com.accolite.dao;

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

import com.accolite.model.User;

@Repository
public class Userdao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User getUser(Integer id){
		String query = "SELECT ID,NAME FROM users where"
				+ " ID = "+id;
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()){
				
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				}
				return user;
			}
		});
	}
	
	
	
}
