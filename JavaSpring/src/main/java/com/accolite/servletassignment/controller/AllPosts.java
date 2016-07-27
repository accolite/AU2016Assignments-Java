package com.accolite.servletassignment.controller;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.servletassignment.dao.PostDAO;
import com.accolite.servletassignment.model.PostResponse;

/**
 * Get all posts
 */
@Controller
public class AllPosts {

	@RequestMapping(value = "/AllPosts",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<PostResponse> doGet(){
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		PostDAO pdao = (PostDAO)ctx.getBean("pdao");
		List<PostResponse> list=pdao.getPosts();
		return list;
}


}
