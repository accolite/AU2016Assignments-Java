package com.chat;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HashMap<String,String> hash=new HashMap<String, String>();   
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//doGet(request, response);
		String usr=request.getParameter("User");
		String password=request.getParameter("Password");
		if(hash.isEmpty() || hash.get(usr)==null)
		{
		
			hash.put(usr,password );
			System.out.println(hash.get(usr));
			RequestDispatcher rd=request.getRequestDispatcher("login.html");  
		       rd.include(request,response);
		}
		else
		{
		    response.sendRedirect("http://localhost:8080/chat/Register.html");
			//RequestDispatcher rd=request.getRequestDispatcher("Register.html");  
		     //  rd.include(request,response);
		}
		

	}

}
