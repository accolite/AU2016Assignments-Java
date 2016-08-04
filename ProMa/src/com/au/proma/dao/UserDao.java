package com.au.proma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.au.proma.model.Role;
import com.au.proma.model.User;
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
	
	public List<User> getAllUsers(){
		String sql = "select * from dbo.Users U , dbo.Role R where U.userroleid=R.roleid";
		return jdbcTemplate.query(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				Role role = new Role(rs.getInt("roleid"),rs.getString("rolename"));
				User user = new User();
				user.setUseremail(rs.getString("useremail"));
				user.setUsername(rs.getString("username"));
				user.setUserid(rs.getInt("userid"));
				user.setRole(role);
				return user;
			}
			
		});
	}
	
	
}
