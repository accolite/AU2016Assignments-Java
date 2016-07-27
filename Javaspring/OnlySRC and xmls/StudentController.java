package com.springdemo.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.jdbctemplate.Student;

@Controller
public class StudentController {
	
	@Autowired
	private JDBCTemplateDao jdbc;
	private Servicelogic sl;
	@RequestMapping(value = "/getStudent",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Student getStudent(){
		 Student student = new Student();
		 student.setStudentId(15);
		 student.setStudentName("Accolite");
		 return student;
	}
	
	@RequestMapping(value="/getStudents",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Student getStudents(@RequestParam("id")int id){
		//jdbc.getStudent(1);
/*		Student student = new Student();
	    student.setStudentId(id);
	    student.setStudentName("XYZ");*/
	    return jdbc.getStudent(1);
	}
	
	@RequestMapping(value="/getStudent/{id}",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Student getStudent(@PathVariable("id")int id){
		Student student = new Student();
	    student.setStudentId(id);
	    student.setStudentName("XYZ");
	    return student;
	}
	@RequestMapping(value="/getChats",method=RequestMethod.GET,produces = "text/plain")
	@ResponseBody
	public String getChats(){
		return sl.getChats();
	    //return student;
	}
	
	@RequestMapping(value="/setChats",method=RequestMethod.GET,produces = "text/plain")
	@ResponseBody
	public String setStudents(@RequestParam("person") String name,@RequestParam("chat") String msg){
		//jdbc.getStudent(1);
/*		Student student = new Student();
	    student.setStudentId(id);
	    student.setStudentName("XYZ");*/
	    return sl.setChats(name,msg)+"";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET,produces = "text/plain")
	@ResponseBody
	public String login(@RequestParam("name") String name,@RequestParam("pw") String pw){
		//jdbc.getStudent(1);
/*		Student student = new Student();
	    student.setStudentId(id);
	    student.setStudentName("XYZ");*/
		/*
	    int ret= sl.login(name,pw);
	    System.out.println(ret);
	    return ret+"";
	    */
		return(jdbc.logincheck(name, pw)+"");
	}
	
}
