package com.au.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.model.Message;

@Controller
public class MainController {
	
	@RequestMapping(value = "/doChat",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Message> doChat(){
		
	}

}
