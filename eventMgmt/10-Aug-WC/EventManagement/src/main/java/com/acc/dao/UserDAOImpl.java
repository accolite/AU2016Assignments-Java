package com.acc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.acc.model.Person;
import com.acc.model.User;;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public int insertUser(Person person){
		String query = "insert into users(name,email_id) values('"+person.getName()+"','"+person.getEmail()+"')";		
		return jdbc.update(query);
	}

	public User getUser(Person person){
		String query = "SELECT * FROM users where"
				+ " email_id = '"+person.getEmail()+"';";
		
		String name = jdbc.query(query, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String string = "";
				while (rs.next()){
					string = rs.getString("name");
				}
				return string;
			}
		});
		
		if(name==null || !name.equals(person.getName())){
			String query1 = "UPDATE users set name='"+person.getName()+"' where email_id='"+person.getEmail()+"';";
			jdbc.update(query1);
		}
		
		return jdbc.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()){
					user.set_id(rs.getInt("_id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email_id"));
				}
				return user.getEmail()==null?null:user;
			}
		});

	}
}
