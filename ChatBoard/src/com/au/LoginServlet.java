package com.au;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = getServletConfig().getServletContext();
		HashMap<String, String> hm = (HashMap<String, String>) application.getAttribute("TabUsrPass");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String usr = request.getParameter("userid");
		String pass = request.getParameter("password");
		String option = request.getParameter("usertype");

		if (option.equals("admin")) {
			if (usr.equals("Admin") && pass.equals("Password")) {
				HttpSession session = request.getSession(false);
				if (session == null)
					session = request.getSession();
				session.setAttribute("username", "Admin");
				session.setAttribute("status", "loggedin");
				response.sendRedirect("Filter.html");
			} else {
				out.print("Sorry, username or password error for admin!");
				response.sendRedirect("Login.html");
			}
		} else {
			if (hm.get(usr) != null && hm.get(usr).equals(pass)) {
				HttpSession session = request.getSession(false);
				if (session == null)
					session = request.getSession();
				session.setAttribute("username", usr);
				session.setAttribute("status", "loggedin");
				response.sendRedirect("Chat.jsp");
			} else {
				out.print("Sorry, username or password error!");
				response.sendRedirect("Login.html");
			}
		}
		out.close();
	}

}
