package com.au.chatbox;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static ArrayList<String> logdusers = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(false);
		if(session==null){
			session = request.getSession();
			if(session.getAttribute(user)!=null){
				RequestDispatcher rd = request.getRequestDispatcher("/chatbox.html");
				rd.forward(request, response);
			}
			else{
				logdusers.add(user);
				RequestDispatcher rd = request.getRequestDispatcher("/chatbox.html");
				rd.forward(request, response);
			}
		}
		if(user.equals("shailendra")){
			RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
			rd.forward(request, response);
		}
		else{
			
		}
	}

}
