package com.accolite.servletassignment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.servletassignment.dao.BlockedDAO;
import com.accolite.servletassignment.model.Blocked;

@Controller
public class BlockerFilter{
	
	@RequestMapping(value = "/Block",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String blockTheseWords(@RequestParam("blockthese") String blockthese){
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		BlockedDAO bdao = (BlockedDAO)ctx.getBean("bdao");
		
		List<String> blocked_local = Arrays.asList(blockthese.split("\\s*,\\s*"));;
		List<Blocked> blocked_post = new ArrayList<Blocked>();
		
		for(String local:blocked_local){
			Blocked blocked = new Blocked();
			blocked.setBlocked_word(local);
			blocked_post.add(blocked);
		}
		
		Integer status=bdao.setBlockedWords(blocked_post);
		return status.toString();
	}

}
