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
//	public Integer getUserId(String name)
//	{
//		String query ="select userid from dbo.users where username='"+name+"'";
//		return jdbcTemplate.query(query, new ResultSetExtractor< Integer>() {
//
//			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
//				
//				
//				Integer temp=0;
//				while (rs.next()){
//				temp=rs.getInt("userid");
//				
//				}
//				return temp;
//			}
//		});
//	}
	public int addUser(User uobj)
	{
		
		String query="insert into users(username,userpassword,useremail,userroleid)"+
						"values('"+uobj.getUsername()+"','"+uobj.getUserpassword()+"','"+uobj.getUseremail()+"','"+uobj.getRole().getRoleid()+"')";
		return jdbcTemplate.update(query);
	}
	
	
	
	
}
