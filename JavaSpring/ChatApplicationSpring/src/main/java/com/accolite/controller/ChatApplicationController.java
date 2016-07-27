package com.accolite.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.java.Message;
import com.accolite.java.User;
import com.accolite.jdbcTemplate.ChatApplicationDao;
import com.accolite.jdbcTemplate.MessageDao;

public class ChatApplicationController {
	
	@Autowired
	private ChatApplicationDao jdbc;
	
	@RequestMapping(value = "/RegisterUser",method=RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public ModelAndView registerUser(@RequestParam("txtUsername")String username, @RequestParam("txtPassword")String password){
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
	    int value=jdbc.registerUser(user);
	    ModelAndView mv;
	    if(value==1)
	    	mv=new ModelAndView("/index.jsp?msg='Registered successfully'");
	    else
	    	mv=new ModelAndView("/Register.jsp?msg='Some error occured. Try Again'");
	    return mv;
	}
	
	@RequestMapping(value = "/UserAuthentication",method=RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public ModelAndView authenticateUser(@RequestParam("txtUsername")String username, @RequestParam("txtPassword")String password){
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
	    int value=jdbc.authenticate(user);
	    ModelAndView mv;
	    if(value==1)
	    	mv=new ModelAndView("/ChatInterface.jsp");
	    else
	    	mv=new ModelAndView("/Login.jsp?msg='Invalid username and password'");
	    return mv;
	}
	
	@RequestMapping(value = "/SendMessage",method=RequestMethod.POST,produces="text/plain")
	@ResponseBody
	public ModelAndView sendMedssage(@RequestParam("hUsername")String username, @RequestParam("txtMessage")String message){
		Message msg=new Message();
		msg.setMessage(message);
		msg.setUsername(username);
	    int value=jdbc.addMessage(msg);
	    ModelAndView mv;
	    mv=new ModelAndView("/ChatInterface.jsp?username="+username);
	    return mv;
	}
	
	
	@RequestMapping(value = "/ChatUpdate",method=RequestMethod.POST,produces="")
	@ResponseBody
	public String ChatUpdate(){
		
	    List<Message> msgLst=jdbc.getAllMessages();
	    String data="";
		for(int i=0;i<msgLst.size();i++){
			
			data+="<b>"+msgLst.get(i).getUsername()+"</b>: "+msgLst.get(i).getMessage()+"<br/><br/>";
			
		}

	    return data;
	}
	
	@RequestMapping(value = "/ActiveUserUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String activeUserUpdate(){
		
	    List<User> userLst=jdbc.getAllActiveUsers();
	    String data="";
		data+="<font color='red'><b>Active Users</b></font><br/>";
		for(int i=0;i<userLst.size();i++){
			data+="<b>"+userLst.get(i).getUsername()+"</b><br/><br/>";
		}
	    
	    return data;
	}
	
	  public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();

	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost/chatroom");
	        dataSource.setUsername("root");
	        dataSource.setPassword("password");

	        return dataSource;
	    }
	
	@RequestMapping(value = "/AdminServlet")
    public String activeUsers(@RequestParam("taBannedWords") String message, HttpServletRequest servletRequest) throws Exception {
        User user = (User) servletRequest.getSession().getAttribute("user");
        MessageDao messageDao = new MessageDao(getDataSource());
        
        for (String s : ChatManager.getBannedWords()) {
            message = message.replace(s, "@banned@");
        }
        if (user != null) {
            ChatManager.getChatRooms().get(0).getMessages().add(new Message(message, user));
            messageDao.insertMessage(message,user.getUsername());
        }
        return "chat";
    }
}
