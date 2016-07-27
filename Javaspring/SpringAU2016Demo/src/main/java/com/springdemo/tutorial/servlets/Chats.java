package com.springdemo.tutorial.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

/**
 * Servlet implementation class Chats
 */
@WebServlet("/Chats")
public class Chats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc=request.getSession().getServletContext();
		/*
		Enumeration<String> names=request.getSession();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}
		*/
		for(String s1:tempstuffs.getUsers().keySet()){
			System.out.println(s1+"  "+tempstuffs.getUsers().get(s1));
		}
		String chats = sc.getAttribute("chats")+" :@#300 ";//+tempstuffs.getActiveusers();
		for(String s1:tempstuffs.getActiveusers()){
			chats+=s1+"</br>";
		}
		response.getWriter().append( chats ); 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
