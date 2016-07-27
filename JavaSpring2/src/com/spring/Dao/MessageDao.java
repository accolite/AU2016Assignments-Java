package com.spring.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.spring.Model.Message;

public class MessageDao {
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public MessageDao(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}

	public MessageDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Message> printmessages(){
		String sql="use Chat_Application select * from dbo.Message_Table";
		return jdbctemplate.query(sql, new RowMapper<Message>(){

			@Override
			public Message mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				return new Message(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4));
			}
			
		});
	}
	public Boolean putMessage(Message message){
		  String sql = "use spring insert into dbo.Message_Table(body,created,username) values(?,?,?)";
		  return jdbctemplate.execute(sql,new PreparedStatementCallback<Boolean>() {

		@Override
		public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			  ps.setString(1, message.getBody());
			    ps.setDate(2,message.getCreated());
			    ps.setString(3,message.getUsername());
			    return ps.execute();
		}
		  });
		 }
}
