package com.accolite.au.chatboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false) != null){
			String user = (String) request.getSession().getAttribute("user");
			/*if(user!=null){
				Set<String> activeList = (HashSet<String>)getServletConfig().getServletContext().getAttribute("activeUsers");
				activeList.remove(user);
				List<String> chatboard = (ArrayList<String>)getServletConfig().getServletContext().getAttribute("chatboard");
				chatboard.add("<br/><small>User <b>"+user+"</b> left the chatboard</small><br/>");
			}*/
			request.getSession().invalidate();
			response.setContentType("text/html");
			response.getWriter().write("Successfully logged out. Click <a href=\"/ChatBoard/\">here</a> to login" );
		}
		else{
			response.setContentType("text/html");
			response.getWriter().write("Please <a href=\"/ChatBoard/\">login</a> first" );
		}
	}

}
