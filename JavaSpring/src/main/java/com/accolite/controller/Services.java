package com.accolite.controller;

public class Services {
	
	private TemplateDAO obj=new TemplateDAO();
	
	  public boolean vaildateLogin(String username,String password){
		  User user =obj.AuthUser(username);
		    if(user.getPassword().equals(password))
		    	return true;
		    else 
		    	return false;
		  }
	  
	  
	  public void registerUser(String username,String password)
	  {
	   User user=new User();
	   user.setUsername(username);
	   user.setPassword(password);
	   obj.RegUser(user);
	  }
	  
	  public void putMessage(String username,String message)
	  {
	  Message message1 = new Message();
	  message1.setUsername(username);
	  message1.setMessage(message);
	  obj.addMessage(message1);
	  }
	  
	  public void Active(String user)
	  {
		  obj.activeUSer(user);
	  }
}
