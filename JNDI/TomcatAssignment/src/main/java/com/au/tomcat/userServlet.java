package com.au.tomcat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.deploy.SessionConfig;

import com.au.tomcatDAO.userDao;

@WebServlet("/employee")
public class userServlet extends HttpServlet{
	
	userDao dao = new userDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		String employee ;
		employee = dao.getEmployee(name);
		response.getWriter().println(employee);;
		
	}
}
