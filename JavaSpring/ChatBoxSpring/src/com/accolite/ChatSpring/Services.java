package com.accolite.ChatSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
	@Autowired
	JDBCTemplateDao jdbctempdao=new JDBCTemplateDao();
	@Autowired
	ActiveUser active=new ActiveUser();
	
	public int addUser(String username, String password)
	{
		User user=new User();
		user.setUserName(username);
		user.setPassword(password);
		return jdbctempdao.addUser(user);
		
	}
	
	public int addMessages(String msg,String username)
	{
		Messages mesg=new Messages();
		mesg.setMessage(msg);
		mesg.setUsername(username);
         return jdbctempdao.addMessages(mesg);	
	}
	
	
	
	public Boolean validateUser(String Username)
	{
		return jdbctempdao.validateUser(Username);
		
	}
	
	public String retrieveMessages(){
		List<Messages> lst=jdbctempdao.retrieveMessages();
		String str="";
		for(Messages l:lst)
		{
			str=str+l.message;
		}
		return str;
		
	}
	
	public String getActive_user() {
		List<String> lst_active=active.getActive_user();
		String str="";
		for(String s:lst_active)
		{
			s+=lst_active;
		}
		return str;
		
	}
	
	public void setActive_user(String username) {
		active.setActive_user(username);
		
		
	}
	
	
public boolean Login(String username, String password){
		
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		User userdb = jdbctempdao.Login(user);
		
		if(userdb.getUserName().equals(username) && userdb.getPassword().equals(password) )
			return true;
		else
			return false;
	}
	
}
