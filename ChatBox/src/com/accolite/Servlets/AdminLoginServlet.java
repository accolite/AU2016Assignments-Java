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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	mainClass mainclass=new mainClass();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		System.out.println("Logged:"+name + " " +password);
		Set<String> activeUsers=mainClass.getActiveUsers(); 
		response.setContentType("text/plains");
	    response.setCharacterEncoding("UTF-8");
		if(name.equals("Admin") && password.equals("RootUser")){
			HttpSession session=request.getSession(false);
			if(session==null)
				session=request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("status", "AdminLoggin");
			activeUsers.add(name);
			String msg="-----"+name+" is online-----";
			List<String> Messages=mainclass.getMessages();
			Messages.add(msg);
			System.out.println("Admin Logged:"+name+" "+password);
			//response.sendRedirect("AdminPage.html");
			response.getWriter().write("success");
		}
		else{
			response.getWriter().write("failed");
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
