package com.accolite.servletassignment.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accolite.servletassignment.dao.PostDAO;
import com.accolite.servletassignment.model.Post;
import com.accolite.servletassignment.model.PostResponse;


@Controller
public class NewPost {
	
	
	@RequestMapping(value = "/NewPost",method=RequestMethod.GET, produces="text/plain")
	@ResponseBody
	
	public String newPost(@RequestParam("name") String name, @RequestParam("post_content") String post_content) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		PostDAO pdao = (PostDAO)ctx.getBean("pdao");
		PostResponse presponse = new PostResponse();
		Post post = new Post();
		post.setPost_content(post_content);
		presponse.setPost(post);
		presponse.setUsername(name);
		Integer post_added = pdao.putNewPost(presponse);
		return post_added.toString();
	}

}
