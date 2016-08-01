package com.au.proma.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.au.proma.model.User;

@Path("projects")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class ProjectResource {

	
	public Map<String,Integer> getAllProjects(){
		Map<String,Integer> m = new HashMap<>();
		m.put("a", 1);
		m.put("b", 2);
		m.put("c", 3);
		return m;
	}
	
	public List<String> test(){
		List<String> l = new  ArrayList<>();
		l.add("AAAA");
		l.add("AAAA");
		l.add("AAAA");
		l.add("AAAA");
		return l;
	}
	
	@Produces(MediaType.TEXT_PLAIN)
	public String test1(){
		return "asdasdasdasd";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> bleh(){
		return null;
		
	}
}
