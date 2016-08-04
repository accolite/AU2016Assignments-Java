package com.au.proma.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.proma.model.BU;
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
	
	
	

}
