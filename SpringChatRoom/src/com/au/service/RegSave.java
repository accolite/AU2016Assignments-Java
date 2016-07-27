package com.au.service;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegSave
 */
@WebServlet("/RegSave")
public class RegSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HashMap<String,String> map = new HashMap<String,String>();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		if(map.get(name)==null) {
	    	map.put(name, pass);
	    	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/login.html");
	    	RequetsDispatcherObj.forward(request, response);
	    }
	    else
	    {
	    	RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/Chatpage.html");
	    	RequetsDispatcherObj.forward(request, response);
	    }
		//System.out.println("Hello");
		//doGet(request, response);
	}

}
