package com.au.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
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
		
		String msg = (String)request.getAttribute("message");
		String user = (String)request.getSession().getAttribute("uname");
		if(user!=null){

		ArrayList<String> chatboard = (ArrayList<String>)getServletConfig().getServletContext().getAttribute("chatboard");
		if(chatboard!=null){
		    String chatlist = "";
		    for(String message: chatboard){
		     if(message.startsWith(user))
		      message = "<b>"+message+"</b>";
		      chatlist += message+"<br/>";
		    }
		    chatlist = chatlist+"</br>"+msg;
		    chatboard.add(msg);
		    getServletConfig().getServletContext().setAttribute("chatboard", chatboard);
		    response.getWriter().write(chatlist);
		   }
		  }
		  else{
		   response.setStatus(500);
		  }
		}
		//doGet(request, response);
	}

