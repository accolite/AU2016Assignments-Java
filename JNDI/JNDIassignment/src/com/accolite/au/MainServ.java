package com.accolite.au;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class MainServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		Context initialContext;

		Principal p = request.getUserPrincipal();

		String s = " ";

		if (request.isUserInRole("manager")) {

			try {
				initialContext = new InitialContext(env);
				Context envContext = (Context) initialContext.lookup("java:/comp/env");
				DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
				Connection connection = dataSource.getConnection();
				Statement stmt = connection.createStatement();
				String sql = "select * from employee";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					s = s + rs.getString(1) + "\n";
					Employee e = new Employee(rs.getString(1), rs.getString(2));

				}
			} catch (SQLException | NamingException exc) {
				exc.printStackTrace();
			} finally {

				request.setAttribute("employeeslist", s);
				request.getRequestDispatcher("/manager.jsp").forward(request, response);
			}

		} else if (request.isUserInRole("user")) {

			String username = p.getName();
			String s1 = " ";

			Employee emp = null;
			try {
				initialContext = new InitialContext(env);
				Context envContext = (Context) initialContext.lookup("java:/comp/env");
				DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
				Connection connection = dataSource.getConnection();
				Statement stmt = connection.createStatement();
				String sql = "select * from employee where name='" + username + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					s1 = s1 + rs.getString(1) + " " + rs.getString(2) + "\n";
					emp = new Employee(rs.getString(1), rs.getString(2));
				}
			} catch (SQLException | NamingException exc) {
				exc.printStackTrace();
			} finally {
				if (emp != null) {
					request.setAttribute("emp", s1);
					request.getRequestDispatcher("/user.jsp").forward(request, response);
				} else
					response.getWriter().append("Your details does not exist.");
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
