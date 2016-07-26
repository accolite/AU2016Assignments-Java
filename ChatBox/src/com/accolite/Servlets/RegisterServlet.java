package com.accolite.Servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	mainClass mainclass=new mainClass();
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    
	public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//System.out.println("Register:"+name + " " +password);
		Map<String, String> users=mainclass.getUsers();
		Set<String> activeUsers=mainClass.getActiveUsers(); 
		users.put(name,password);
		activeUsers.add(name);
		HttpSession session=request.getSession(false);
		if(session==null)
			session=request.getSession();
		session.setAttribute("username", name);
		session.setAttribute("status", "loggedin");
		String msg="     -----"+name+" is online-----";
		List<String> Messages=mainclass.getMessages();
		Messages.add(msg);
		//response.sendRedirect("chatPage.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
