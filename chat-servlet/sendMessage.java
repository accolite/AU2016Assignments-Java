package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class sendMessage
 */
@WebServlet(description = "putting the message in database", urlPatterns = { "/sendMessage" })
public class sendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sendMessage() {
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

		String message = (String) request.getAttribute("message");

		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();

		try {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("name");
			System.out.println(userName+" "+message);
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into chat (message, username) values(?,?)");
			
			preparedStatement.setString(1, message);
			preparedStatement.setString(2, userName);
			
			preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());


	}

}
