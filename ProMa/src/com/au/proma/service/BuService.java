package com.au.proma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.BuDao;
import com.au.proma.model.BU;
import com.au.proma.model.User;

@Service
public class BuService {
	
	@Autowired
	private BuDao buDao;
	
	public List<BU> getAllBU(){
		return buDao.getAllBU();
	}
	
	public int addBU(BU bu){
		return buDao.addBU(bu);
	}

	public Boolean addBUHead(BU bu, User user){
		return buDao.addBUHead(bu, user);
	}
	
	public Boolean removeBU(BU bu){
		return buDao.removeBU(bu);
	}
	
	public Boolean removeBUHead(BU bu,User user){
		return buDao.removeBUHead(bu, user);
	}
	
	public BU getBUDetails(int buid){
		List<BU> allBUs = getAllBU();
		for (BU bu : allBUs) {
			if(bu.getBuid()==buid)
				return bu;
		}
		return null;
	}
}
