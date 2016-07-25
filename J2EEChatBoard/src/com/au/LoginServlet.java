package com.au;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name1");
		String pass = request.getParameter("pass1");
		if(RegisterSave.map.get(name) != null){
			try {
				HttpSession session=request.getSession();  
		        session.setAttribute("uname",name);
		        session.setAttribute("upass", pass);
				RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/chatboard.jsp");
		    	RequetsDispatcherObj.forward(request, response);
			}catch(Exception e){System.out.println(e);} 
		}
		else {
			try{
				response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
				out.print("Invalid Login"+ name);
				out.close();
			}catch(Exception e){System.out.println(e);} 
		}
		doGet(request, response);
	}

}
