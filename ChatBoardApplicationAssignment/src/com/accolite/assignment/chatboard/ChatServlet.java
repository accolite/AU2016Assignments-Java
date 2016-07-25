package com.accolite.assignment.chatboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */

public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static StringBuilder sb=new StringBuilder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
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
		doGet(request, response);
		String chat_message=request.getParameter("outputChat");
	
		  PrintWriter pw=response.getWriter();
		  pw.println(chat_message);
		 sb.append(chat_message);sb.append(" ");
		  RequestDispatcher dispatcher = request.getRequestDispatcher("Chat.jsp");
		  request.setAttribute("Name", sb); // set your String value in the attribute
		  dispatcher.forward( request, response );
		  
		 }
}
