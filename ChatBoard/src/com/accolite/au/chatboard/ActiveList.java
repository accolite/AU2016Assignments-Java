package com.accolite.au.chatboard;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActiveList
 */
@WebServlet("/activelist")
public class ActiveList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String)request.getSession().getAttribute("user");
		if(user!=null){
			Set<String> activeList = (HashSet<String>)getServletConfig().getServletContext().getAttribute("activeUsers");
			if(activeList != null){
				String list = "";
				for(String name: activeList){
					if(name.equals(user))
						name = "<b>"+user+"</b>";
					list = list+name+"<br/>";
				}
				response.getWriter().write(list);
			}
			else
				response.getWriter().write("No active users");
		}
		else{
			response.setStatus(500);
		}
	}

}
