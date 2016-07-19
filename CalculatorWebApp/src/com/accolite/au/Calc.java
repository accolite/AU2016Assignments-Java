package com.accolite.au;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calc
 */
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Does calculator operation
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float a = 0;
		float b = 0;
		int op = 0;
		float ans = 0;
		try{
			a = Float.parseFloat(request.getParameter("arg1"));
			b = Float.parseFloat(request.getParameter("arg2"));
			op = Integer.parseInt(request.getParameter("option"));
//			System.out.println(a+" "+b+" "+op);
		}
		catch(NumberFormatException nfe){}
		switch (op) {
		case 1:
			ans = a+b;
			break;
		case 2:
			ans = a-b;
			break;
		case 3:
			ans = a*b;
			break;
		case 4:
			ans = a/b;
			break;
		default:
			break;
		}
		String result = "Result is "+ans;
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
