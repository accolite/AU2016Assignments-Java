package com.au;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		getServletContext().setAttribute("ctxtAttr", "This is from second to first");
		String s1 = getServletContext().getInitParameter("ctxtname");
		String s2 = getServletConfig().getInitParameter("lastname");
//		session.setMaxInactiveInterval(200);
//		session.invalidate();
		response.getWriter().append("howdy from second servlet "+s1+ " "+s2+" \nSessionUser: "+session.getAttribute("user"));
		
		//RequestDispatcher rd = request.getRequestDispatcher("/FirstServlet");
		//rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
