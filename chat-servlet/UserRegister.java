package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet(description = "user registration servlet", urlPatterns = { "/Register" })
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
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

		String userName = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");

		System.out.println(userName + " " + password);
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		
		try {

			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users (username, mypassword) values(?,?)");

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
		
			preparedStatement.executeUpdate();
			
			connection.close();
			response.sendRedirect("/ServletAssignment/index.jsp");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			response.sendRedirect("/ServletAssignment/index.jsp");
		}

	}

}
