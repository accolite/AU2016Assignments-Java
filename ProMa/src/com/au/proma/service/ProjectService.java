package com.au.proma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.ProjectDao;
import com.au.proma.model.BU;
import com.au.proma.model.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	public List<Project> getAllProjects(){
		return projectDao.getAllProjects();
	}
	
	public List<Project> getProjectsUnderBU(BU bu){
		return projectDao.extractProjectsUnderBU(bu);
	}
	
}
