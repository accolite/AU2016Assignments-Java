package com.acc.dao;

import com.acc.model.Person;
import com.acc.model.User;

public interface UserDAO {
	public int insertUser(Person person);
	public User getUser(Person person);
	
}
