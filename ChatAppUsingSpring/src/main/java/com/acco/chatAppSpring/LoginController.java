package com.acco.chatAppSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin()
	{
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(@ModelAttribute("loginBean")LoginBean loginBean)
	    {
	        ModelAndView model= null;
	        try
	        {
	            boolean isValidUser = userDao.isValidUser(loginBean.getUsername(), loginBean.getPassword());	
	            if(isValidUser)	
	            {	
	              System.out.println("User Login Successful");
	              model = new ModelAndView("login");
	              model.addObject("loggedInUser", loginBean.getUsername());
	            }	
	            else	
	            {
		           model = new ModelAndView("login");	
		           model.addObject("loginBean", loginBean);
                   //request.setAttribute("message", "Invalid credentials!!");	
	            }	
	        }
		    catch(Exception e)	
	        {	
	           e.printStackTrace();	
	        }	 
	        return model;
	
	    }
	
	}

