package com.accolite.servletassignment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.servletassignment.model.User;

@Repository
public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;  

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<User> getUsers(){
		String query = "SELECT * FROM users where active=1;";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<User>>(){
			
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException{
				List<User> users=new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setActive(rs.getInt("active"));
					users.add(user);
				}
				return users;
			}
		});
	}
	
	public User getUser(User user){
		String query = "SELECT * FROM users where user_id="+user.getUser_id()+";";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>(){
			
			public User extractData(ResultSet rs) throws SQLException, DataAccessException{
				User user=new User();
				while(rs.next()){
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setActive(rs.getInt("active"));
				}
				return user;
			}
		});
	}
	
	public User getUserLogin(User user){
		String query = "SELECT * FROM users where name='"+user.getName()+"' and password='"+user.getPassword()+"';";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>(){
			
			public User extractData(ResultSet rs) throws SQLException, DataAccessException{
				User user=null;
				while(rs.next()){
					user=new User();
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setActive(rs.getInt("active"));
				}
				if(user!=null){
					user.setActive(1);
					updateUser(user);
				}
				return user;
			}
		});
	}
	
	public User getUserLogout(User user){
		String query = "SELECT * FROM users where user_id="+user.getUser_id()+";";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>(){
			
			public User extractData(ResultSet rs) throws SQLException, DataAccessException{
				User user=new User();
				while(rs.next()){
					user.setUser_id(rs.getInt("user_id"));
					user.setName(rs.getString("name"));
					user.setActive(rs.getInt("active"));
				}
				if(user!=null){
					if(user.getActive()!=0)
						user.setActive(0);
					else
						user.setActive(-1);
				}
				return user;
			}
		});
	}

	public int registerUser(User user){  
		String query="insert into users values('"+user.getName()+"','"+user.getPassword()+"','"+user.getActive()+")";  
		return jdbcTemplate.update(query);  
	}  
	
	public int updateUser(User user){  
		String query="update users set active="+user.getActive()+" where id='"+user.getUser_id()+"' ";  
		return jdbcTemplate.update(query);  
	}  
	
}  