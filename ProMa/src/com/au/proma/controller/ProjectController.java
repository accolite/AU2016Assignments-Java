package com.au.proma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.proma.model.Project;
import com.au.proma.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Project> getAllProjects(){
		List<Project> p = projectService.getAllProjects();
		return p;
	}
	
}
