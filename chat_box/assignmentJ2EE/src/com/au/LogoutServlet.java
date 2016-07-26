package com.au;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		Boolean flag = false;
		HttpSession session = request.getSession(false);
		if(session != null) {
			String user = (String) session.getAttribute("username");
			session.invalidate();
			LoginUserServlet.activeUsers.remove(user);
			if(HomeServlet.msg == null)
				HomeServlet.msg = new StringBuilder(" ");
			System.out.println(user + " logged out.");
			HomeServlet.msg.append("\n\n" + user + "is logged out");
			response.sendRedirect("http://localhost:8080/assignmentJ2EE/firstScreen.html");
			flag = true;
		}
		//response.getWriter().append(flag + "");
		//doGet(request, response);
	}

}
