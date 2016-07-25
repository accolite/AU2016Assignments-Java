package com.au.chat;

	import java.io.IOException;
	import java.io.PrintWriter;
	 
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	 
	public class Login extends HttpServlet  
	{
	    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
	    	Register register = new Register();
	    	
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
	 
			String user=req.getParameter("userName");
			String pass=req.getParameter("userPassword");
			
		
			
			if(Register.allUsers.containsKey(user))
			{
				if(Register.allUsers.get(user).equals(pass))
				{
					pw.println("Login Successfull");
				}
				else
				{
					pw.println("Wrong Password");
				}

			}
			
			else
			{
				pw.println("Register First");
			}
		
		}
	}

