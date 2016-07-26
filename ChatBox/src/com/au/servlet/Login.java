package com.au.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authenticate
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
		// TODO Auto-generated method stub
		response.getWriter().write("Not a valid operation");
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		Map<String, String> userslist = (HashMap<String, String>)getServletConfig().getServletContext().getAttribute("users");
		
		System.out.println(username + "  "+ password);
		if(userslist != null){
			if(userslist.containsKey(username) && userslist.get(username).equals(password)){
				request.getSession().setAttribute("user", username);
				Set<String> activeList = (HashSet<String>)getServletConfig().getServletContext().getAttribute("activeUsers");
				if(activeList == null)
					activeList = new HashSet<>();
				if(!activeList.contains(username)){
					activeList.add(username);
					getServletConfig().getServletContext().setAttribute("activeUsers", activeList);
					List<String> chatbox = (ArrayList<String>)getServletConfig().getServletContext().getAttribute("chatbox");
					if(chatbox == null)
						chatbox = new ArrayList<>();
					chatbox.add("User <b>"+username+"</b> joined the chatbox");
					System.out.println("User "+username+" joined the chatbox");
					getServletConfig().getServletContext().setAttribute("chatbox", chatbox);
				}
				response.sendRedirect("/ChatBox/chatbox.jsp");
			}
		}
		response.setContentType("text/html");
		response.getWriter().write("Login invalid. <a href=\"/ChatBox/\">Try</a> again");

	
	}

}
