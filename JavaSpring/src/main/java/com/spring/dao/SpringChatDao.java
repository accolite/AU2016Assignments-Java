package com.spring.dao;

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

//import com.springdemo.tutorial.jdbctemplate.Student;

//import com.springdemo.tutorial.jdbctemplate.Student;

@Repository
public class SpringChatDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean Register(String name, String pass){
		String query = "INSERT into Springchat.dbo.Users( User_name,Password) values"
				+ "("+name+","+pass+");";
		try{
			jdbcTemplate.execute(query);
		}
		catch(Exception e){
			
			return false;
		}
		return true;
		
	}
	
	public boolean Login(String name,String pass){
		String query = "Select User_name from Springchat.dbo.Users "
				+ "where User_name=="+name+" and Password== "+pass+";";
		// ResultSetExtractor<String> = new ResultSetExtractor();
		return  jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			@Override
			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.getString(0)==null){
					return false;
				}
				else{
					String query = "INSERT into Springchat.dbo.LogUser( User_name) values"
							+ "("+name+");";
					try{
						jdbcTemplate.execute(query);
					}
					catch(Exception e){
						
						return false;
					}
					return true;
				}
				
			}
			
			
		});
	}

	public boolean Talk(String name, String msg) {
		// TODO Auto-generated method stub
		String query = "INSERT into Springchat.dbo.Messages( User_name,Message) values"
				+ "("+name+","+msg+");";
		try{
			jdbcTemplate.execute(query);
		}
		catch(Exception e){
			
			return false;
		}
		return true;
		
	}
	public List<String> Chat(){
		String query = "Select * from Springchat.dbo.Messages;";
		return  jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
					List<String> talk = new ArrayList<String>();
					@Override
					public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while(rs.next()){
						talk.add(rs.getString(0)+" "+rs.getString(1)+"\n");
					}
					return talk;
					}
					
					
				});
	}

	public String Users() {
		// TODO Auto-generated method stub
		String query = "Select * from Springchat.dbo.Users;";
		return  jdbcTemplate.query(query, new ResultSetExtractor<String>() {
			String users ="";
			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
			while(rs.next()){
				users+=rs.getString(0)+"\n";
			}
			return users;
			}
			
			
		});
	}

	public boolean Logout(String name) {
		// TODO Auto-generated method stub
		String query = "delete User_name from Springchat.dbo.Users where User_name= "+name+";";
		try{
			jdbcTemplate.execute(query);
		}
		catch(Exception e){
			
			return false;
		}
		return true;
	}
	
}