package com.au.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;




@Repository
public class ChatboxDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean register(String userName, String password) {
	
			String sql = "INSERT INTO springChatbox.dbo.user(userName, password) values('" + userName + ",'" + password + "')";			
			try{
				jdbcTemplate.execute(sql);
			
			} catch(Exception e) {
				return false;
			}		
		return true;
	}

	public boolean login(String userName, String password) {
		String query = "Select count(*) from springChatbox.dbo.user where userName='" + userName + "' and password='" + password+"'";			
		HashMap<String , String> map = new HashMap<>();
		
	 jdbcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if (rs.getInt(0) == 0) {
					return false;
				} else {
					
					String sql = "INSERT INTO springChatbox.dbo.activeUser(userName) values('" + userName + "')";						
						jdbcTemplate.execute(sql);			
					
					return true;
				}
			}
		});
				
		return true;
	}

	public boolean addMessage(String userName, String message) {
		String sql = "INSERT INTO springChatbox.dbo.message(userName, message) values('" + userName + ",'" + message + "')";			
		try{
			jdbcTemplate.execute(sql);
		
		} catch(Exception e) {
			return false;
		}		
	return true;
	}

	public List<String> getChat() {
		List<String> chat = new ArrayList<String>();
		String query = "Select * from springChatbox.dbo.message";	
		 jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
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

	public List<String> getActiveUser() {
		List<String> users = new ArrayList<String>();
		String query = "Select * from springChatbox.dbo.activeUser";	
		 jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while(rs.next()) {
						String temp = rs.getString(0);
						users.add(temp);
					}
					return users;
				}
			});
		 return users;
	}

	public boolean logout(String userName) {
		String sql = "DELETE FROM springChatbox.dbo.acitveUser(userName) values('" + userName + "')";			
		try{
			jdbcTemplate.execute(sql);
		
		} catch(Exception e) {
			return false;
		}		
	return true;
	}
}




