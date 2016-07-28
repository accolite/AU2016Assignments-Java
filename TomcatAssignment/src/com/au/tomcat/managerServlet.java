package com.au.tomcat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.au.DAO.ManagerDao;

@WebServlet("/manager")
public class managerServlet extends HttpServlet {
	
	 public managerServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	ManagerDao dao = new ManagerDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jUserDB");
			List<String> employees = new ArrayList<String>();
			employees = dao.getAllEmployees();
			request.setAttribute("employeeList", employees);
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/displyEmployee.jsp");
	        reqDispatcher.forward(request,response);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
