package com.au.proma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.proma.model.BU;
import com.au.proma.model.Project;
import com.au.proma.model.Sprint;
import com.au.proma.service.Color;
import com.au.proma.service.ProjectService;
import com.au.proma.service.SprintService;
import com.au.proma.service.UserService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/status",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Color> statusOfEveryBU()
	{
		//System.out.println(p.getProjectname());
		return projectService.statusOfEveryBU();
	}
	
	
	@RequestMapping(method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public int insertProject( @RequestBody Project p)
	{
		//System.out.println(p.getProjectname());
		int row_affected =  projectService.insertProject(p);
		if(row_affected > 0)
			userService.notifyEachAdmin("admin",p,"Project Added");
		return row_affected;
	}
	
	
	@RequestMapping(value = "/{id}",method=RequestMethod.PUT,consumes="application/json",produces = "application/json")
	@ResponseBody
	public String editProject(@RequestBody Project project,@PathVariable("id") int project_id){
		Boolean isSuccess = projectService.updateProject(project_id,project);
		if(isSuccess)
			userService.notifyEachAdmin("admin",project,"Project Updated");
		return isSuccess ? "Success" : "Failure";
	}
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Project getProject(@PathVariable("id") int project_id){
		return projectService.getProject(project_id);
	}
	
	@RequestMapping(value="/bus/{bu_id}",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Project> getProjectsUnderBU(@PathVariable("bu_id") int buid){
		BU bu = new BU();
		bu.setBuid(buid);
		return projectService.getProjectsUnderBU(bu);
		
	}
	
	@RequestMapping(value="/{pid}/sprints",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Sprint> getSprintsUnderProject(@PathVariable("pid") int pid){
		return sprintService.getAllSprints(pid);
		
	}
	
	@RequestMapping(value="/{pid}/sprints",method=RequestMethod.POST,consumes = "application/json",produces="application/json")
	@ResponseBody
	public String addSprintUnderProject(@RequestBody Sprint sprint,@PathVariable("pid") int pid){
		return sprintService.addSprint(sprint, pid);
		
	}
	
	@RequestMapping(value="/{pid}/sprints/{sprintid}",method=RequestMethod.PUT,consumes = "application/json",produces="application/json")
	@ResponseBody
	public String updateSprintUnderProject(@RequestBody Sprint sprint,@PathVariable("sprintid") int sprintid,
			@PathVariable("pid") int pid){
		return sprintService.updateSprint(sprint, sprintid);
		
	}
	
	@RequestMapping(value="/closeSprint",method=RequestMethod.PUT,produces="application/json")
	@ResponseBody
	public String closeCurrentSprintUnderProject(@RequestBody Project project){
		 return projectService.closeCurrentSprint(project,project.getCurrentSprint());
		
	}
	
	@RequestMapping(value="/{id}/getDataPoints",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<Integer> getDataPoints(@PathVariable("id") int projectid){
		return sprintService.getDataPoints(projectid);
	}
	
}

