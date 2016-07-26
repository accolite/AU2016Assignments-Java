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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	mainClass mainclass=new mainClass();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//System.out.println("Logged:"+name + " " +password);
		Map<String, String> users=mainclass.getUsers();
		Set<String> activeUsers=mainClass.getActiveUsers(); 
		response.setContentType("text/plains");
	    response.setCharacterEncoding("UTF-8");
	    if(!users.isEmpty() && users.get(name).equals(password)){
			HttpSession session=request.getSession(false);
			if(session==null)
				session=request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("status", "loggedin");
			activeUsers.add(name);
			//System.out.println("User Logged:"+name+" "+users.get(name));
			//response.sendRedirect("chatPage.html");
			String msg="     -----"+name+" is online-----";
			List<String> Messages=mainclass.getMessages();
			Messages.add(msg);
			String result="success";
			response.getWriter().write(result);
		}
	    else
	    {
	    	String result="failed";
	    	response.getWriter().write(result);
			//response.sendRedirect("index.html");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
