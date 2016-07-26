package com.accolite.au.assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Message
 */
@WebServlet(description = "Broadcasts message", urlPatterns = { "/Message" })
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String messages= null;
		if(request.getParameter("message").equals(""))
		{
			messages=(String) getServletConfig().getServletContext().getAttribute("messages");
			//response.getWriter().println(messages);
		}else
		if(getServletConfig().getServletContext().getAttribute("messages") == null)
		{
			String user=(String) request.getSession().getAttribute("username");
			 messages=user+":"+request.getParameter("message")+"\n";
			 getServletConfig().getServletContext().setAttribute("messages", messages);
		}
		else
		{
			String user=(String) request.getSession().getAttribute("username");
		     messages=(String) getServletConfig().getServletContext().getAttribute("messages");
		     messages=	messages.concat(user+":"+request.getParameter("message")+"\n");
			getServletConfig().getServletContext().setAttribute("messages", messages);
		}
		response.setStatus(200);
		//System.out.println(messages);
		System.out.println("List of online users:");
		System.out.println("abc,def");
		response.getWriter().println(messages);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}