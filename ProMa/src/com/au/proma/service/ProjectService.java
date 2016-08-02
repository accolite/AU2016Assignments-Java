package com.au.proma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.ProjectDao;
import com.au.proma.model.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	public List<Project> getAllProjects(){
		return projectDao.getAllProjects();
	}

	public Boolean updateProject(int project_id, Project project) {
		// TODO Auto-generated method stub
		project.setProjectid(project_id);
		int no_of_affected_records = projectDao.updateProject(project);
		if(no_of_affected_records > 0)
			return true;
		else
			return false;
	}
	
	
}
