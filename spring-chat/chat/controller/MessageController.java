package com.accolite.chat.controller;

import org.codehaus.jettison.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.chat.service.ChatService;

@Controller
public class MessageController {

	@Autowired
	private ChatService chatService;

	/*
	 * This method returns the list of messages containing username and message.
	 * Each message has an unique id generated in the database by using auto
	 * increment. The @param id is used to get the list of all messages that
	 * came after the message having that particular id(all latest messages).
	 */
	@RequestMapping(value = "/Message",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public JSONArray getMessages(@RequestParam("id") int id){
		return chatService.getMessages(id);
	}

	/*
	 * The function will insert message into database by calling the service. If the message 
	 * is successfully entered it returns success or it returns failure which can be used to 
	 * alert the user.
	 */
	@RequestMapping(value = "/Message",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String sendMessage(@RequestParam("username") String username, @RequestParam("message") String message){
		boolean success = chatService.sendMessage(username, message);
		if(success){
			return "success";
		}else {
			return "false";
		}
	}

}
