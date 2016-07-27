package com.au.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.au.model.Message;
import com.au.model.User;

public class MessageDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public MessageDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public MessageDao() {
		super();
	}

	public List<Message> getAllMessages(){
		String sql = "use spring select * from dbo.messagetable;";
		
		return jdbcTemplate.query(sql, new RowMapper<Message>(){

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Message(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4));
			}
			
		});
		
	}
	
	public Boolean putMessage(Message message){
		String sql = "use spring insert into dbo.usermessage(body,created,username) values(?,?,?)";
		return jdbcTemplate.execute(sql,new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, message.getBody());
				ps.setDate(2,message.getCreated());
				ps.setString(3,message.getUsername());
				return ps.execute();
			}
		});
	}
	

}
