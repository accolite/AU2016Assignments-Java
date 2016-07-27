package com.au.assignment.jdbctemplate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;




@Repository
public class JDBCTemplateDAO {
@Autowired
private JdbcTemplate jdbcTemplate;
public UserDetail vaildatateUser(String name)
{
		String query = "SELECT Username,password FROM LoginTable where"
				+ " Username = "+name;
		return jdbcTemplate.query(query, new ResultSetExtractor<UserDetail>() {

			public UserDetail extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserDetail user1 = new UserDetail();
				while (rs.next()){
					String user=rs.getString("Username");
					String pass=rs.getString("password");
					if(user.equals(name))
					{
						user1.setUsername(name);
						user1.setPassword(pass);
					}
						return user1;
	
	}
	return null;
	
}
		});
}
public int registerUser(UserDetail user){
	String query = "insert into LoginTable(Username,STUDENT_NAME) values "
			+ "("+user.getUsername()+",'"+user.getPassword()+"')";		
	return jdbcTemplate.update(query);
}
public List<Message> GetChatList()
{
	List<Message> messages=null;
		String query = "SELECT Username,message FROM MessageTable ";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {

			public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Message msg = new Message();
				while (rs.next()){
					msg.setUsername(rs.getString("Username"));
					msg.setMessage(rs.getString("message"));
						messages.add(msg);
	}
	return messages;
	
}
		});
}
 public int PostMessageTable(Message msg){
		String query = "insert into MessageTable(message,Username) values "
				+ "("+msg.getMessage()+",'"+msg.getUsername()+"')";		
		return jdbcTemplate.update(query);
	}
 public int SetActiveUser(UserDetail user)
 {
	 String query = "Update LoginTable SET active=1 where Username="+user.getUsername();		
		return jdbcTemplate.update(query);
 }
 public int SetInActiveUser(UserDetail user)
 {
	 String query = "Update LoginTable SET active=0 where Username="+user.getUsername();		
		return jdbcTemplate.update(query);
 }
}
		

