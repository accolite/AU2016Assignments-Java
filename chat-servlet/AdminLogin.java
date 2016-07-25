package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet(description = "Admin Login Checker", urlPatterns = { "/adminLogin" })
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
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
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select mypassword from admin where username=?");
			preparedStatement.setString(1, name);
			ResultSet rSet = preparedStatement.executeQuery();
			
			while(rSet.next()){
				String pass = rSet.getString(1);
				if(pass.equals(password)){
					response.sendRedirect("/ServletAssignment/adminHome.html");
				}
				
				else{
					response.sendRedirect("/ServletAssignment/index.jsp");
				}
			}
			
			connection.close();
			
			response.sendRedirect("/ServletAssignment/index.jsp");
			
		} catch (Exception e) {
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}

}
