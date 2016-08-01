package com.au.proma.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	public int insertProject(Project p)
	{
		return projectDao.insertProject(p);
	}
	public HashMap<String, Color> statusOfEveryBU()
	{
		HashMap<String, Color> map=new HashMap<String,Color>();
		
		ArrayList<Project> projectList=projectDao.statusOfEveryBU();
		for(Project temp:projectList)
		{
			String buname=temp.getBu().getBuname();
			Date today=new Date();
			Date enddate=temp.getEnddate();
			//System.out.println(today);
			//System.out.println("idckb");
			//System.out.println(enddate);
			Color c=null;
			if(map.get(buname)==null)
			{
				c=new Color();
				map.put(buname, c);
			}
			else
			c=map.get(buname);
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
		return map;
	}
}
