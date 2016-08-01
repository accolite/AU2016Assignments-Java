package com.au.proma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.ClientDao;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;
}
