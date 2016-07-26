package com.au.servletandjsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static StringBuilder msg;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //public static StringBuilder message=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  String myText = request.getParameter("myText");
		  String myText = (String) getServletContext().getAttribute("userText");
		//  msg = (StringBuilder) request.getServletContext().getAttribute("message");
		  HttpSession user=request.getSession();
		  String username=(String) user.getAttribute("name");
		  
		  if(msg==null)
			  msg = new StringBuilder(username+":"+ myText+"\n");
		  else
			   msg.append("\n\n"+username+":"+ myText +"\n\n");
		  
		  response.getWriter().append(msg);
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
	}

}
