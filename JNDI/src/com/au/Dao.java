package com.au;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dao {

	private Dao jdbcTemplate; 
	static ResultSet rs;
	
	public Employee getEmployee(int id) {
		
		Connection conn = null;
		Statement stmt = null;
		Employee user = new Employee();
		
		try {
			//register driver
			Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
			
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.username, Constants.password);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = conn.createStatement();

			String sql;
			sql = "SELECT id, name, password, email, role FROM employee where id = "+ id;
			rs = stmt.executeQuery(sql);

			
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			user.setEmail(rs.getString("email"));
			
		}
		catch(Exception e) {}
		
		return user;
	}	
	
}
