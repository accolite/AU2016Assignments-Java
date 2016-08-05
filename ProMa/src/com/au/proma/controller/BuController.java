package com.au.proma.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.proma.model.BU;
import com.au.proma.model.User;
import com.au.proma.service.BuService;

@Controller
@RequestMapping("/bus")
public class BuController {
	
	@Autowired
	private BuService buService;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<BU> getAllBU(){
		return buService.getAllBU();
	}
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json",consumes="application/json")
	@ResponseBody
	public Integer addBU(@RequestBody BU bu){
		return buService.addBU(bu);
	}
	
	@RequestMapping(value="/{buid}",method=RequestMethod.DELETE, produces="application/json")
	@ResponseBody
	public Boolean removeBU(@PathVariable("buid") int buid){
		BU bu = new BU();
		bu.setBuid(buid);
		return buService.removeBU(bu);
	}
	
	@RequestMapping(value="/{buid}/buheads",method=RequestMethod.POST, produces="application/json",consumes="application/json")
	@ResponseBody
	public Boolean addBUHead(@RequestBody User user,@PathVariable("buid") int buid){
		BU bu = new BU();
		bu.setBuid(buid);
		return buService.addBUHead(bu, user);
	}

	@RequestMapping(value="/{buid}/buheads/{userid}",method=RequestMethod.DELETE, produces="application/json",consumes="application/json")
	@ResponseBody
	public Boolean addBUHead(@PathVariable("buid") int buid,@PathVariable("userid") int userid){
		BU bu = new BU();
		bu.setBuid(buid);
		User user = new User();
		user.setUserid(userid);
		return buService.removeBUHead(bu, user);
	}
	

}
