package com.accolite.servletAssignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Logout
 */
@WebServlet(description = "logging out user", urlPatterns = { "/Logout" })
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("username");
		System.out.println(userName);
		String notifUser = userName;
		ArrayList<String> activeUsers = new ArrayList<String>();
		activeUsers = (ArrayList<String>) getServletContext().getAttribute("activeUsers");
		
		Iterator< String> iterator = activeUsers.iterator();
		while(iterator.hasNext()){
			if(userName.equals(iterator.next())){
				iterator.remove();
			}
		}
		System.out.println(activeUsers);
		getServletContext().setAttribute("activeUsers", activeUsers);
		
		session.invalidate();
		
		String notification = (String)getServletContext().getAttribute("notif");
		notification = notification +"\n"+notifUser+" had left";
		
		
		getServletContext().setAttribute("notif", notification);
		
		response.sendRedirect("/ServletAssignment/index.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
