package com.au.proma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.au.proma.model.*;
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate  jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getPassword(String name)
	{
		String query ="select userid,userpassword from dbo.users where username='"+name+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor< String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				
				String temp="";
				while (rs.next()){
				temp=rs.getString("userpassword");
				
				}
				return temp;
			}
		});
	}
	public int addUser(User uobj)
	{
		
		String query="insert into users(username,userpassword,useremail,userroleid)"+
						"values('"+uobj.getUsername()+"','"+uobj.getUserpassword()+"','"+uobj.getUseremail()+"','"+uobj.getRole().getRoleid()+"')";
		return jdbcTemplate.update(query);
	}
	public String getEmailID(String name)
	{
		String query ="select useremail from dbo.users where username='"+name+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor< String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				
				String temp="";
				while (rs.next()){
				temp=rs.getString("useremail");
				
				}
				return temp;
			}
		});
	}
	public int addToken(String name,String token)
	{
		
		String query="update dbo.users set token= '"+ token+
						"' where username='"+name+"'";
		return jdbcTemplate.update(query);
	}
	public String getUserName(String token)
	{
		String query ="select username from dbo.users where token='"+token+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor< String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				
				String temp="";
				while (rs.next()){
				temp=rs.getString("username");
				
				}
				return temp;
			}
		});
	}
	public int setPassword(String new_pass,String token)
	{
		
		String query="update dbo.users set userpassword= '"+ new_pass+
						"' where token='"+token+"'";
		return jdbcTemplate.update(query);
	}
	
}
