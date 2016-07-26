package com.accolite.au.chatboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
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
		response.getWriter().write("Not a valid operation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false)!=null){
			System.out.println("Session already exist");
			request.getSession().invalidate();
		}
		else
		{
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			Map<String, String> userslist = (HashMap<String, String>)getServletConfig().getServletContext().getAttribute("users");
			if(userslist != null){
				if(userslist.containsKey(user) && userslist.get(user).equals(password)){
					request.getSession().setAttribute("user", user);
					Set<String> activeList = (HashSet<String>)getServletConfig().getServletContext().getAttribute("activeUsers");
					if(activeList == null)
						activeList = new HashSet<>();
					if(!activeList.contains(user)){
						activeList.add(user);
						getServletConfig().getServletContext().setAttribute("activeUsers", activeList);
						List<String> chatboard = (ArrayList<String>)getServletConfig().getServletContext().getAttribute("chatboard");
						if(chatboard == null)
							chatboard = new ArrayList<>();
						chatboard.add("<br/><small>User <b>"+user+"</b> joined the chatboard</small><br/>");
						System.out.println("User "+user+" joined the chatboard");
						getServletConfig().getServletContext().setAttribute("chatboard", chatboard);
					}
					response.sendRedirect("/ChatBoard/chatboard.jsp");
				}
			}
		}
		response.setContentType("text/html");
		response.getWriter().write("Login invalid. <a href=\"/ChatBoard/\">Try</a> again");
	}
}
