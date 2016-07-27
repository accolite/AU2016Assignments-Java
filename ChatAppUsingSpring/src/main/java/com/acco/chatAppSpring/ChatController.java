package com.acco.chatAppSpring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String getChat(HttpServletRequest request,HttpServletResponse response)
	{
		String msg = (String)request.getSession().getAttribute("msg");
		String currUserName = (String)request.getAttribute("currUser");
		return "Msg : "+msg + "user: "+currUserName;
	}
	
	@RequestMapping(value = "/activeUsers", method = RequestMethod.GET)
	public ArrayList<String> getActiveUsers(HttpServletRequest request,HttpServletResponse response)
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> userNames = (ArrayList<String>)request.getSession().getAttribute("activeUsers");
		return userNames;
	}
}
