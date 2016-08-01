package com.au.proma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.BuDao;

@Service
public class BuService {
	
	@Autowired
	private BuDao buDao;

}
