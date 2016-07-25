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
				out.println("Admin Logged In");
				request.getRequestDispatcher("Filter.html").include(request, response);
			} else {
				out.print("Sorry, username or password error for admin!");
			}
		} else {
			if (hm.get(usr).equals(pass)) {
				out.println("Successfully Logged In ");
			} else {
				out.print("Sorry, username or password error!");
				request.getRequestDispatcher("Login.html");
			}
		}
		out.close();
	}

}
