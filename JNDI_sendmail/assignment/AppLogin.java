package com.accolite.jndi.assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class AppLogin
 */
@WebServlet(description = "Login for Employee and Manager", urlPatterns = { "/AppLogin" })
public class AppLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getUserPrincipal().getName();
		System.out.println("name: "+name);
		boolean auth = request.isUserInRole("Manager");
		if(name.equals("manager")){
			System.out.println("Manager");
			response.sendRedirect("http://localhost:8080/ServletAssignment/managerHome.html");
		}
		else if(!auth){
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			System.out.println("employee");
			response.sendRedirect("http://localhost:8080/ServletAssignment/employeeHome.html");
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
