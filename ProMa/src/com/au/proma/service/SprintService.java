package com.au.proma.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.SprintDao;
import com.au.proma.model.Sprint;
import com.au.proma.util.Colour;
import com.au.proma.util.Constants;

@Service
public class SprintService {

	@Autowired
	private SprintDao sprintDao;

	public Colour getSprintStatus(Sprint sprint) {
		double task_left;
		int completed = sprint.getCompleted();
		Date startDate = sprint.getStartdate();
		Date endDate = sprint.getEnddate();
		Date currDate = new Date(Calendar.getInstance().getTime().getTime());
		double no_of_days_in_sprint = Math.abs(((double) endDate.getTime() - startDate.getTime()) / 86400000);
		double no_of_completed_days_in_sprint = Math
				.abs(((double) currDate.getTime() - startDate.getTime()) / 86400000);
		double required_completion = new Double((double) no_of_completed_days_in_sprint / no_of_days_in_sprint * 100)
				.intValue();
		try {
			if(currDate.before(startDate))
				return Colour.GREEN;
			if(currDate.after(endDate))
				task_left = (1 - (double)completed)/100;
			else 
				task_left = ((double) required_completion - completed) / required_completion;
			if (task_left > Constants.YELLOW_RED_THRESHOLD)
				return Colour.RED;
			else if (task_left > Constants.GREEN_YELLOW_THRESHOLD)
				return Colour.YELLOW;
			else
				return Colour.GREEN;
		} catch (ArithmeticException e) {
			return Colour.GREEN;
		}
	}

	public List<Sprint> getAllSprints(int pid) {
		// TODO Auto-generated method stub
		List<Sprint> sprints = sprintDao.getAllSprintsUnderProject(pid);
		for (Sprint sprint : sprints)
			sprint.setColour(getSprintStatus(sprint));
		return sprints;
	}

	public String addSprint(Sprint sprint, int pid) {
		// TODO Auto-generated method stub
		int no_of_rows_affected = sprintDao.insertSprint(sprint, pid);
		if (no_of_rows_affected > 0)
			return Constants.SUCCESS_MESSAGE;
		else
			return Constants.FAILURE_MESSAGE;
	}

	public String updateSprint(Sprint sprint, int sprintid) {
		// TODO Auto-generated method stub
		sprint.setSprint_id(sprintid);
		int no_of_rows_affected = sprintDao.updateSprint(sprint);
		if (no_of_rows_affected > 0)
			return Constants.SUCCESS_MESSAGE;
		else
			return Constants.FAILURE_MESSAGE;
	}
}
