package com.au.proma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
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
	
	public List<User> getUserWithRoleId(int roleId){
		String query = "select * from users where userroleid = "+roleId;
		return jdbcTemplate.query(query, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserid(arg0.getInt("userid"));
				user.setUsername(arg0.getString("username"));
				user.setUserpassword(arg0.getString("userpassword"));
				user.setUseremail(arg0.getString("useremail"));
				
				return user;
			}
			
		});
	}
	
	public List<String> getUsersEmailWithRoleId(int roleId){
		String query = "select useremail from users where userroleid = "+roleId;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<String>>(){

			@Override
			public List<String> extractData(ResultSet arg0) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<String> emails  = new ArrayList<String>();
				while(arg0.next())
					emails.add(arg0.getString("useremail"));
				return emails;
			}
			
		});
	}
	
	
}
