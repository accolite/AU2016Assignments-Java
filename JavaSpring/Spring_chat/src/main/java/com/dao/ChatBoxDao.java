package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class ChatBoxDao {

	@Autowired 
	JdbcTemplate jdbcTemplate;
	public boolean reg(String uname,String pwd)
	{
		String sql = "INSERT INTO register() values('" + uname + ",'" + pwd + "')";   
		   try{
		    jdbcTemplate.execute(sql);
		   } catch(Exception e) {
		    return false;
		   }  
		  return true;
	}public boolean login(String userName, String password) {
		  String query = "Select count(*) from chat_spring.dbo.register where userName='" + userName + "' and password='" + password+"'";   
		  
		  jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

		   public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
		    
		    if (rs.getInt(0) == 0) {
		     return false;
		    } else {
		     
		     String sql = "INSERT INTO chat_spring.dbo.login(userName) values('" + userName + "')";      
		      jdbcTemplate.execute(sql);   
		     
		     return true;
		    }
		   }
		  }
		  );
		  return true;
		 }
	public boolean inserttmsg(String uname, String msg) {
		  String sql = "INSERT INTO springChatbox.dbo.message(uname, msg) values('" + uname + ",'" + msg + "')";   
		  try{
		   jdbcTemplate.execute(sql);
		  
		  } catch(Exception e) {
		   return false;
		  }  
		 return true;
		 }

		 public ArrayList<String> getmsg() {
		  ArrayList<String> chat = new ArrayList<String>();
		  String query = "Select * from springChatbox.dbo.msg"; 
		   jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<String>>() {

		    public ArrayList<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		     while(rs.next()) {
		      String temp = rs.getString(0);
		      temp += " : ";
		      temp += rs.getString(1);
		      chat.add(temp);
		     }
		     return chat;
		    }
		   });
		   return chat;
		 }
}