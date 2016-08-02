package com.au.proma.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.proma.model.BU;
import com.au.proma.model.Project;
import com.au.proma.service.Color;
import com.au.proma.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/status",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public HashMap<String, Color> statusOfEveryBU()
	{
		//System.out.println(p.getProjectname());
		return projectService.statusOfEveryBU();
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public int insertProject( @RequestBody Project p)
	{
		//System.out.println(p.getProjectname());
		return projectService.insertProject(p);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Project> getAllProjects(){
		List<Project> p = projectService.getAllProjects();
		return p;
	}
	
	@RequestMapping(value="/bus/{bu_id}",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Project> getProjectsUnderBU(@PathVariable("bu_id") int buid){
		BU bu = new BU();
		bu.setBuid(buid);
		return projectService.getProjectsUnderBU(bu);
		
	}
	
}

