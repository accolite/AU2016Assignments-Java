package com.au.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.au.model.User;

public class UserDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserDao() {
		super();
	}

	public Boolean registerUser(User user){
		String sql = "use spring insert into dbo.usertable(username,active,passw) values(?,?,?)";
		return jdbcTemplate.execute(sql,new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1,user.getUsername());
				ps.setInt(2, user.getActive());
				ps.setString(3,user.getPassword());
				return ps.execute();
			}
		});
	}

	public List<User> getListofLoggedInUsers(){
		String sql = "use spring select * from dbo.usertable where active=1";
		return jdbcTemplate.query(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User( rs.getString(1) , rs.getInt(2) , rs.getString(3) );
				
			}});
	}
	
	public String getPassword(User user){
		String sql = "use spring select passw from dbo.usertable where username='" + user.getUsername() +"';";
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>(){

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				return rs.next() ? rs.getString("passw"): null;
			}});
		
	}
	
	public void setActive(User user){
		String sql = "use spring update dbo.usertable set active=1 where  username='" + user.getUsername() +"';";
		jdbcTemplate.execute(sql);
	}
}
