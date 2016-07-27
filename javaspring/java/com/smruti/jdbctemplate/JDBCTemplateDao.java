package com.smruti.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	public User getUser(User user){
		String query = "SELECT id, usr, pwd, status FROM userData where"
				+ " usr = "+user.getName();
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()){
				
				user.setUserId(rs.getInt("id"));
				user.setName(rs.getString("usr"));
				user.setPassword(rs.getString("pwd"));
				user.setStatus(rs.getString("status"));
				}
				return user;
			}
		});
	}
	
	public User getUser(int id){
		String query = "SELECT id, usr, pwd, status FROM userData where"
				+ " id = "+ id;
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()){
				
				user.setUserId(rs.getInt("id"));
				user.setName(rs.getString("usr"));
				user.setPassword(rs.getString("pwd"));
				user.setStatus(rs.getString("status"));
				}
				return user;
			}
		});
	}
	
	public int saveUser(User user){
		String query = "insert into userData(usr, pwd, status) values "
				+ "("+user.getName()+",'"+user.getPassword()+",'"+user.getStatus()+"')";		
		return jdbcTemplate.update(query);
	}
	
	public Message getMessage(Integer id){
		String query = "SELECT id, usrid, msg FROM msgs where"
				+ " mid = "+id;
		return jdbcTemplate.query(query, new ResultSetExtractor<Message>() {

			public Message extractData(ResultSet rs) throws SQLException, DataAccessException {
				Message message = new Message();
				while (rs.next()){
				
				message.setMid(rs.getInt("mid"));
				message.setUid(rs.getInt("usrid"));
				message.setMsg(rs.getString("msg"));
				}
				return message;
			}
		});
	}
	
	public int saveMessage(Message message){
		String query = "insert into msgs(usrid, msg) values "
				+ "("+ message.getUid() +",'"+ message.getMsg() +"')";		
		return jdbcTemplate.update(query);
	}

	public void setStatus(User user) {
		// TODO Auto-generated method stub
		String query = "update userData set status = 'active' where usr = '" + user.getName() +"'";
	}
	
	public void reSetStatus(User user) {
		// TODO Auto-generated method stub
		String query = "update userData set status = 'inactive' where usr = '" + user.getName() +"'";
	}
	
}
