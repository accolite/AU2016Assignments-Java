/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.model.Person;
import com.acc.service.LoginService;
import com.acc.util.GooglePOJO;

/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
	/** The login service. */
	@Autowired
    private LoginService loginService;
 
    public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * method home exposed at /
	 * view to handle request at /
	 * @param request
	 * @param model
	 * @return page name to be loaded
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        if(request.getSession(false) != null && request.getSession(false).getAttribute("type")!=null)
        	return "main_prod_material";
        else
        	return "index";
    }
    
    /**
     * method login exposed at /login
     * checking for successful login
     * @param googlePojo
     * @param request
     * @param model
     * @return person logged in
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Person login(@RequestBody GooglePOJO googlePojo, HttpServletRequest request, Model model) {
    	return loginService.checkLogin(googlePojo, request);
    }
    
    /**
     * method logout exposed at logout
     * invalidate session and logout.
     * @param request
     * @param model
     * @return nothing
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout(HttpServletRequest request, Model model) {
      HttpSession session = request.getSession(false);
      System.out.println(session.getAttribute("type"));
      session.invalidate(); 
      return "logout";
    }
}
