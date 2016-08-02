package com.au.proma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/{id}",method=RequestMethod.PUT,consumes="application/json",produces = "application/json")
	@ResponseBody
	public String editProject(@RequestBody Project project,@PathVariable("id") int project_id){
		Boolean isSuccess = projectService.updateProject(project_id,project);
		return isSuccess ? "Success" : "Failure";
	}
	
}
