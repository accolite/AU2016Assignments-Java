package com.acc.dao;

import com.acc.model.Admin;
import com.acc.model.Person;

public interface AdminDAO {
	public Integer insertAdmin(Person person);
	public Admin getAdmin(Person person);
}
