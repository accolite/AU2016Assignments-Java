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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	static HashMap<String, String> up = new HashMap<String, String>();
	static HashMap<String, String> nu = new HashMap<String, String>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();
		application.setAttribute("TabUsrPass", up);
		application.setAttribute("TabUsrName", nu);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Name");
		String usrname = request.getParameter("userid");
		String password = request.getParameter("password");
		if(up.get(usrname)==password){
			out.println("You've already registered");
		}
		else{
			up.put(usrname, password);
			nu.put(usrname, name);
			out.println("Successfully Registered");
			//out.println(up.size());;
			request.getRequestDispatcher("Main.html").include(request, response);
		}
		out.close();
	}

}
