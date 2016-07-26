package com.accolite.au.chatboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext ctxt = getServletConfig().getServletContext();
		Map<String, String> userslist = (HashMap<String, String>)ctxt.getAttribute("users");
		if(userslist == null){
			userslist = new HashMap<>();
		}
		if(userslist.containsKey(user)){
			System.out.println("Already registered");
			response.setContentType("text/html");
			response.getWriter().write("The username is already registered.Please <a href=\"/ChatBoard/\">try</a> again");
		}
		else{
			userslist.put(user, password);
			System.out.println("Successfully added");
			ctxt.setAttribute("users", userslist);
			response.setContentType("text/html");
			response.getWriter().write("Successfully registered.Please <a href=\"/ChatBoard/\">login</a> again");
		}
	}

}
