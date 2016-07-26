/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 26, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/
package com.accolite.chatdemo;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;

/**
 * Servlet implementation class Login
 */
@WebServlet(asyncSupported = true, description = "login servelet", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
//		HashMap<String, String> map=getServletContext().getAttribute("users");
		if(User_information.map.get(name)==null||User_information.map.get(name).equals(pass)==false)
		{
			response.getWriter().append("Invalid Login.");
		}
		else
		{
			
			if(UserOnline.map.get(name)!=null&&UserOnline.map.get(name).equals(pass)==true)
			{
				//you are active already
				response.sendRedirect("chat.jsp");
			}
			else
			{
				//new user logged in
				getServletContext().setAttribute("activeusers", UserOnline.map);
				UserOnline.map.put(name, pass);
				HttpSession sess=request.getSession(true);
				sess.setAttribute("name",name);
				sess.setAttribute("pass", pass);
				Chat chat=new Chat(name,name+"joined");
				ArrayChat.chats.add(chat);
				response.sendRedirect("chat.jsp");
			
			}
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
