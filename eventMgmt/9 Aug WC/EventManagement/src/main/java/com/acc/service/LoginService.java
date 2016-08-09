package com.acc.service;

import javax.servlet.http.HttpServletRequest;

import com.acc.model.Person;
import com.acc.util.GooglePOJO;

public interface LoginService {
	public Person checkLogin(GooglePOJO googlePojo, HttpServletRequest request);
}
