package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.ACTIVE;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(description = "login check for user", urlPatterns = { "/login" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
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

		// Map<String, String> credentials = null;
		String userName = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");
		// credentials = (Map<String, String>)
		// getServletContext().getAttribute("credentials");

		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		try {
			

			PreparedStatement preparedStatement = connection
					.prepareStatement("select mypassword from users where username=?");
			
			preparedStatement.setString(1, userName);
			
			ResultSet rSet = preparedStatement.executeQuery();
			
			while(rSet.next()){
				String pass = rSet.getString(1);
				if(pass.equals(password)){

					HttpSession session = request.getSession(false);
					if (session == null) {
					// Not created yet. Now do so yourself.
					session = request.getSession();
					}
					
					session.setAttribute("name", userName);
					// Already created.
					ArrayList<String> activeUsers = null;

					activeUsers = (ArrayList<String>)
					getServletContext().getAttribute("activeUsers");

					if (activeUsers == null) {
					activeUsers = new ArrayList<String>();
					}
					else{
						Iterator<String> iterator = activeUsers.iterator();
						while(iterator.hasNext()){
							if(userName.equals(iterator.next())){
								System.out.println("users equal");
								iterator.remove();
							}
						}
					}
					System.out.println("hello");
					System.out.println(activeUsers);
					activeUsers.add(userName);
					getServletContext().setAttribute("activeUsers", activeUsers);

					session.setAttribute("username", userName);
					
					String notification = (String)getServletContext().getAttribute("notif");
					notification = notification +"\n"+userName+" has joined";
					
					
					getServletContext().setAttribute("notif", notification);
				
					response.sendRedirect("/ServletAssignment/chat.html");
				}
				else{
					response.sendRedirect("/ServletAssignment/index.jsp");
				}
			
				
			}
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
		}

	}

}
