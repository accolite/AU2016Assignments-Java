package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.locale.StringTokenIterator;

/**
 * Servlet implementation class ProhibitWords
 */
@WebServlet(description = "prohibiting words", urlPatterns = { "/prohibit" })
public class ProhibitWords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProhibitWords() {
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
		// doGet(request, response);

		ArrayList<String> prohibit = null;

		StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("words"), ",");

		String proWord = null;

		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into prohwords (word) values(?)");
			while (stringTokenizer.hasMoreTokens()) {
				proWord = stringTokenizer.nextToken();
				
				preparedStatement.setString(1, proWord);
				preparedStatement.executeUpdate();
			}
			
			connection.close();
		} catch (Exception e) {
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}


		response.sendRedirect("http://localhost:8080/ServletAssignment/");

	}

}
