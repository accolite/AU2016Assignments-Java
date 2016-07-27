package com.spring.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.Model.User;

public class UserDao {
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public UserDao(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public Boolean registerUser(User user)
	{
		String sql="use Chat_Application insert into dbo.UserTable(username,active,passw) values(?,?,?)";
		return jdbctemplate.execute(sql,new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1,user.getUsername());
				ps.setInt(2, user.getActive());
				ps.setString(3, user.getPassword());
				return ps.execute();
			}
		} );
	}
	public String getpassword(User user)
	{
		String sql="use Chat_Application select passw from dbo.UserTable where username='" + user.getUsername() +"';";
		return jdbctemplate.query(sql,new ResultSetExtractor<String>(){

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return rs.next() ? rs.getString("passw"):null;
			}
			
		});
		
	}
	public List<User> LoggedInUsers(){
		  String sql = "use spring select * from dbo.usertable where active=1";
		  return jdbctemplate.query(sql, new RowMapper<User>(){

		   @Override
		   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		    return new User( rs.getString(1) , rs.getInt(2) , rs.getString(3) );
		    
		   }});
		 }
	 public void setActive(User user){
		  String sql = "use spring update dbo.usertable set active=1 where  username='" + user.getUsername() +"';";
		  jdbctemplate.execute(sql);
		 }
}
