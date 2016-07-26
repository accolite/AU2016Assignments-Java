package com.au;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> activeUsers = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuilder users = new StringBuilder();
		int i;
		if(activeUsers.size() != 0)
			users = users.append(activeUsers.get(0));
		for(i = 1; i < activeUsers.size(); i++)
			users = users.append(" , " + activeUsers.get(i));
		response.getWriter().println(users);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String usr = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(RegisterUserServlet.hm.isEmpty() == false) {
			String password = RegisterUserServlet.hm.get(usr);
			System.out.println("user : " + usr +" \tpassword : " + password + "\tpwd : "+ pwd);
			if(password == null || password.equals(pwd) == false) {
				System.out.println("incorrect password or user");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");	
			    rd.include(request,response);
			}	
			else {
				HttpSession session = request.getSession(false);
				if(session == null) {
					session = request.getSession();
					session.setAttribute("username", usr);
					activeUsers.add(usr);
					if(HomeServlet.msg == null)
						HomeServlet.msg = new StringBuilder(" ");
					HomeServlet.msg.append("\n\n" + usr + "is logged in.");
					/*RequestDispatcher rd=request.getRequestDispatcher("Home.html");	
				    rd.include(request,response);*/
					response.sendRedirect("http://localhost:8080/assignmentJ2EE/Home.html?username="+usr);
				}
				else {
					response.sendRedirect("http://localhost:8080/assignmentJ2EE/Login.html");
				}
			}
		}	
	}

}
