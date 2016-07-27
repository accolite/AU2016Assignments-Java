package com.au.springchat.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.au.springchat.resources.UserData;

@Repository
public class JDBCTemplatedao {

	@Autowired
	JdbcTemplate  jdbcTemplate;

	public void Register(UserData userData) {
		String sql = "INSERT INTO Users " + "(Name, Useraname,Password) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { userData.getName(), userData.getUsername(), userData.getPassword() });
	}

	public void InsertMessage(UserData userData) {
		String sql = "INSERT INTO Messages " + "(message) VALUES (?)";
		jdbcTemplate.update(sql, new Object[] { userData.getName() + ":" + userData.getMessage() });
	}

	public void insertFilterWords() {

	}

	public List<String> getChatHistory() {
		return jdbcTemplate.query("select * from Messages", new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rownumber) throws SQLException {
				String e = new String();
				e = rs.getString(1);
				return e;
			}
		});
 	}
	
	public String getPassword(String username){
		String sql="select Password from Users where Useraname="+username;
		List<String> list=  jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rownumber) throws SQLException {
				String e = new String();
				e = rs.getString(1);
				return e;
			}
		});
		return list.get(0);
	}
	
	public Connection getDbConnection() throws SQLException{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource)applicationContext.getBean("dataSource");
		Connection c = ds.getConnection();
		return c;
	}
}
