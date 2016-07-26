package com.au;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HashMap<String, String> hm = new HashMap<String, String>();

    /**
     * Default constructor. 
     */
    public RegisterUserServlet() {
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
		//doGet(request, response);
		String usr = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(hm.isEmpty() || hm.get(usr) == null) {			
			hm.put(usr, pwd);
			System.out.println("user : " + usr + "\tpwd : "+ pwd);
			RequestDispatcher rd=request.getRequestDispatcher("firstScreen.html");  
		     rd.include(request,response);
		}	
		else {
			 RequestDispatcher rd=request.getRequestDispatcher("Register.html");  
		     rd.include(request,response); 
		}	
	}

}
