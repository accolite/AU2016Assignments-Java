package com.accolite.jndi;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/Login")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		
		try{
			/**
			 * Initializing environment context and checking
			 */
			Context initialContext = new InitialContext(env);
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			String manchester = (String) envContext.lookup("manchester");
			System.out.println(manchester);
			
			
			/**
			 * Get logged in user name
			 */
			String user = request.getUserPrincipal().getName();
			request.setAttribute("user", user);
			
			/**
			 * Send different requests for different users.
			 */
			RequestDispatcher dispatcher = null;
			if(request.isUserInRole("manager")){
				dispatcher = getServletContext().getRequestDispatcher("/LoggedInManager");
				dispatcher.forward(request, response);
			}else if(request.isUserInRole("employee")){
				dispatcher = getServletContext().getRequestDispatcher("/LoggedInEmployee");
				dispatcher.forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
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
