package com.springdemo.tutorial.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.*;
@Controller
public class MeetingController {
	@Autowired
	private JDBCTemplateDao jdbc;
	
	@RequestMapping(value = "/addTrainer",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public String addTrainer(@RequestParam("SessionID") int SessionID, @RequestParam("TrainerID") int TrainerID){
		Session session = new Session();
		session.setSessionID( SessionID );
		User trainer = new User();
		trainer.setUserID( TrainerID );
		jdbc.addTrainer( trainer, session);
		return "Session alloted to Trainer";
	}
	
	@RequestMapping(value = "/getSessions",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TrainerID") int TrainerID){
		User Trainer = new User();
		Trainer.setUserID(TrainerID);
		return jdbc.getSessions(Trainer);
	}
	
	
	
}
