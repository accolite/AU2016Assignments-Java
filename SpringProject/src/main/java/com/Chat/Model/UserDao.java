package com.Chat.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.Chat.Model.Users;

public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Users Login(String name,String password){
		String query = "SELECT username,password from dbo.Users where userName="+name+" and password="+password; 
		return jdbcTemplate.query(query, new ResultSetExtractor<Users>() {

			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				Users user=null;
				if(rs.first()){ 
					user = new Users();
				while (rs.next()){
				
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setUser(rs.getInt("user"));
				}}
				return user;
			}
		});
	}
	
	public int setStatus(String userName)
	{
		String query="update dbo.Users set status=1 where userName="+userName;
		return jdbcTemplate.update(query);
	}
}
