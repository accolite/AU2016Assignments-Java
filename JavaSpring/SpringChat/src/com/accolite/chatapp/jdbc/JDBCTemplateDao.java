package com.accolite.chatapp.jdbc;

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
import org.springframework.stereotype.Repository;



@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean validUser(String username){
		String query="Select Username from UserDetails where username="+username;
		return jdbcTemplate.query(query,  new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if(rs.next()==false)
					return true;
				else{
					return false;
				}
			}
		});
		
	}
	
	public Boolean addUser(final User user){
		String query = "insert into UserDetails(username,password) values (?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				return ps.execute();
			}
		});
		
	}
	
	public Boolean validate(User user){
		String query="Select username,password from UserDetails where username='"+user.getUsername()+"' "+"and"+" "+"password='"+user.getPassword()+"'";
		return jdbcTemplate.query(query,  new ResultSetExtractor<Boolean>() {

			public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if(rs.next()==false)
					return false;
				else{
					return true;
				}
			}
		});
	
	}
	
	
	
	public int addMessage(String username,String message) {
		String query="Insert into Message(username,message) Values ('"+username+"','"+message+"')";
		return jdbcTemplate.update(query);	
	}
	
	public List<Message> getAllMessages() {
		  
		  
		  return jdbcTemplate.query("select * from Message", new ResultSetExtractor<List<Message>>(){

		   @Override
		   public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
		    
		    List<Message> list = new ArrayList<Message>();
		    
		    while(rs.next()){
		     Message m = new Message();
		     m.setUsername(rs.getString(1));
		     m.setMessage(rs.getString(2));
		     list.add(m);
		    }
		    
		    return list;    
		   }
		  });
		    
		 }
	

}
