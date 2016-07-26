package com.au;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddFilters
 */
@WebServlet("/AddFilters")
public class AddFilters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFilters() {
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
		ChatBoardData cbd = ChatBoardData.getDataInstance();
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		if (session == null ) {
			
			out.println("");
			return;
		}
		out.println(request.getParameter("filter"));
		if (session.getAttribute("username").equals("Admin")) {
			cbd.addFilter(request.getParameter("filter"));
		}
		response.sendRedirect("Filter.html");
	}

}
