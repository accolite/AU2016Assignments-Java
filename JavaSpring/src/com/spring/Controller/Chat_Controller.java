package com.spring.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.Model.Message;
import com.spring.Service.MessageService;

@Controller
public class Chat_Controller {
	
	@RequestMapping(value = "/Chat",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Message> Chat(){
		MessageService ms=new MessageService();
		
		
	}
	
}
