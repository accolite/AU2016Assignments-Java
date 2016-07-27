package com.accolite.servletassignment.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.servletassignment.dao.BlockedDAO;
import com.accolite.servletassignment.model.Blocked;


@Controller
public class BlockedController{
	
	
	@RequestMapping(value = "/Blocked",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Blocked> getBlockedWords(){
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		BlockedDAO bdao = (BlockedDAO)ctx.getBean("bdao");
		List<Blocked> list=bdao.getBlockedWords();
		return list;
	}
}
