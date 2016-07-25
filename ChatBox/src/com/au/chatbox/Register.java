package com.au.chatbox;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet(
		description = "Register an application to chat", 
		urlPatterns = { "/Register" }, 
		initParams = { 
				@WebInitParam(name = "admin", value = "Shailendra", description = "Admin of chatRoom")
		})
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HashMap<String, String> users = new HashMap();
	public static final String admin="shailendra";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		getServletContext().setAttribute("regusers", users);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession(false);
		
		
		
		PrintWriter pw = response.getWriter();
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		if(users.containsKey(user)){
			pw.append("You are Already Registerd");
		}
		else{
			users.put(user, pass);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
		//System.out.println("you are");
		//pw.append("register+ "+user+" "+pass);
	}

}
