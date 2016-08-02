package com.au.proma.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

	public Boolean updateProject(int project_id, Project project) {
		// TODO Auto-generated method stub
		project.setProjectid(project_id);
		int no_of_affected_records = projectDao.updateProject(project);
		if(no_of_affected_records > 0)
			return true;
		else
			return false;
	}
	
	public List<Project> getProjectsUnderBU(BU bu){
		return projectDao.extractProjectsUnderBU(bu);
	}
	
	public int insertProject(Project p)
	{
		return projectDao.insertProject(p);
	}
	public List<Color> statusOfEveryBU()
	{
		Map<Integer, Color> map=new HashMap<Integer,Color>();
		
		List<Project> projectList=projectDao.statusOfEveryBU();
		for(Project temp:projectList)
		{
			int buid=temp.getBu().getBuid();
			String buname = temp.getBu().getBuname();
			Date today=new Date();
			Date enddate=temp.getEnddate();
			Color c=null;
			if(map.get(buid)==null)
			{
				c=new Color();
				c.setBu(temp.getBu());
				map.put(buid, c);
			}
			else
			c=map.get(buid);
			if(enddate!=null){
			long duration=today.getTime()-enddate.getTime();
			long daysleft=TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
			
			if(daysleft<=15)
				c.incrementRed();
			else if(daysleft>15&&daysleft<=30)
				c.incrementYellow();
			else
				c.incrementGreen();
			
			c.incrementTotal();
			}
		}
		List<Color> list = new ArrayList<Color>(map.values());
		return list;
	}
}
