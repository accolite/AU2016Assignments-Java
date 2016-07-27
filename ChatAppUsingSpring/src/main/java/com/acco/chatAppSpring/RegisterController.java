package com.acco.chatAppSpring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class RegisterController {
	@Autowired
	private RegisterDao registerDao;
		
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView executeregister(@ModelAttribute("register")RegisterBean registerBean)
	    {
	        ModelAndView model= null;
	        try
	        {
	            boolean isValidRegister = registerDao.register(registerBean.getUsername(), registerBean.getPassword());	
	            if(isValidRegister)	
	            {	
	              System.out.println("User register Successful");
	              model = new ModelAndView("login");
	              model.addObject("loggedInUser", registerBean.getUsername());
	            }	
	            else	
	            {
		           model = new ModelAndView("register");	
		           model.addObject("register", registerBean);
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
