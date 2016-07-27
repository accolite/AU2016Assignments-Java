package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.ChatBoxDao;

import com.service.ChatBoxSer;
@Controller
public class ChatBox {
	
	@Autowired
	private ChatBoxDao jdbc;
	private ChatBoxSer cs;
	@RequestMapping(value = "/reg/(uname)/(psw)",method=RequestMethod.GET)
	@ResponseBody
	public boolean reg(@RequestParam("uname") String uname,@RequestParam("psw") String pwd)
	{
		return cs.reg(uname, pwd);
		
	}
	@RequestMapping(value = "/login/",method=RequestMethod.POST)
	@ResponseBody
	public boolean login(@RequestParam("uname") String uname,@RequestParam("psw") String pwd)
	{
		return cs.login(uname,psw);
	}
	@RequestMapping(value = "/inserttmsg/",method=RequestMethod.POST)
	@ResponseBody
	public boolean insertmsg(@RequestParam("uname") String uname,@RequestParam("msg") String msg)
	{
		return cs.insertmsg(uname,msg);
	}
	@RequestMapping(value = "/getmsg/",method=RequestMethod.GET,produces= "application/json")
	@ResponseBody
	public ArrayList<String> getmsg()
	{
		return cs.getmsg();
	}
	@RequestMapping(value = "/logout/",method=RequestMethod.POST)
	@ResponseBody
	public void logout(@RequestParam("uname") String uname)
	{
		
	}
}
