package com.au.jdbctemplate;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertWord(String word) {

	    String query = "insert into Words(Word) values "
				+ "("+word+"')";		
		return jdbcTemplate.update(query);

}
	
	public int insertUser(Users user) {
		String query = "insert into Student(Name,UserName,Password) values "
				+ "("+user.getName()+",'"+user.getUname()+",'"+user.getPassword()+"')";		
		return jdbcTemplate.update(query);
	}
	
	public int insertMessage(Messages msg) {
		String query = "insert into Student(UserName,MessageContent) values "
				+ "("+msg.getUserName()+",'"+msg.getMessageContent()+"')";		
		return jdbcTemplate.update(query);
	}
	

		public ArrayList<Messages> getAllMessages() {
			 return jdbcTemplate.query( "SELECT UserName,MessageContent FROM Messages ",new ResultSetExtractor<ArrayList<Messages>>(){  
			    public ArrayList<Messages> extractData(ResultSet rs) throws SQLException,DataAccessException {  
			      
			    	ArrayList<Messages> list=new ArrayList<Messages>();  
			
			    	while(rs.next()){  
			        Messages msg=new Messages(); 	         
			        msg.setMessageContent(rs.getString("MessageContent"));
					msg.setUserName(rs.getString("UserName"));
			        list.add(msg);  
			        }  
			        return list;  
			        }  
			    });  
			  }  
		
			
		
	public Users getUser(final String uname){
		String query = "SELECT Name,UserName,Password FROM Users where"
				+ " UserName = "+uname;
		return jdbcTemplate.query(query, new ResultSetExtractor<Users>() {

			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				Users u = new Users();
				u=null;
				while (rs.next()){
				if((rs.getString("UserName")).equals(uname)){	
				u.setUname(rs.getString("UserName"));
				u.setName(rs.getString("Name"));
				u.setPassword(rs.getString("Password"));
				return u;
			     }
				}
				return u;
			}
		});
	}
	
	public ArrayList<String> getAllWords() {
		 return jdbcTemplate.query( "SELECT Word FROM Words ",new ResultSetExtractor<ArrayList<String>>(){  
		    public ArrayList<String> extractData(ResultSet rs) throws SQLException,DataAccessException {  
		      
		    	ArrayList<String> list=new ArrayList<String>();
		        while(rs.next()){   			         
		        list.add(rs.getString("Word")); 
		        }  
		        return list;  
		        }  
		    });  
}  
	
	
}
