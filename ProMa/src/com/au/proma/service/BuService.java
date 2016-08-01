package com.au.proma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.BuDao;
import com.au.proma.model.BU;

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

}
