package com.au.chatboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.au.chatboard.bean.Message;

@Component
public class MessageManager {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addMessage(Message message){
		String query = "INSERT INTO Messages (username, message) values ('"+message.getUsername()+"','"+message.getMessage()+"')";
		return jdbcTemplate.update(query);	
	}
	
	public List<Message> retrieve(){
		String query = "SELECT * FROM Messages";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {

			@Override
			public List<Message> extractData(ResultSet paramResultSet) throws SQLException, DataAccessException {
				List<Message> list = new ArrayList<>();
				while(paramResultSet.next()){
					Message m = new Message();
					m.setUsername(paramResultSet.getString(1));
					m.setMessage(paramResultSet.getString(2));
					list.add(m);
				}
				return list;
			}
		});
	}
}
