package com.accolite.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.classfiles.Messages;
import com.accolite.classfiles.Users;

@Component("jdao")
public class JDBCTemplateDao {
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public String addUser(Users user){
		
		String query = "use ChatRoomSpring insert into users(name,userpassword,userrole,userstatus) values "
				+ "('"+user.getName()+"','"+user.getPassword()+"','"+user.getRole()+"','"+user.getStatus()+"')";		
		int result = jdbcTemplate.update(query);
		if(result==0)
			return "failed";
		else
			return "success";
	}
	
	public String checkUser(String name,String password){
		return null;
	}
	
	public String checkAdmin(String name,String password){
		return null;
	}
	
	public void addBannedWords(String words){
		
	}
	
	public String addMessage(Messages msg){
		String query = "use ChatRoomSpring insert into message(author,usermessage) values "
				+ "('"+msg.getAuthor()+"','"+msg.getMessage()+"')";		
		int result = jdbcTemplate.update(query);
		if(result==0)
			return "failed";
		else
			return "success";
	}
	
	public String getMessages(){
		
		return null;
	}
	
}
