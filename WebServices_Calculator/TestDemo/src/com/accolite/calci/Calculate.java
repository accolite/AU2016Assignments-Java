/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
package com.accolite.calci;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Calculate.
 */
@WebServlet(description = "calculator servlet", urlPatterns = { "/Calculate" })
public class Calculate extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new calculate.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** gets the parameter number1 from the http request object*/
		int number1 = Integer.parseInt(request.getParameter("number1"));
		/** gets the parameter operation from the http request object*/
		String operation=request.getParameter("operation");
		/** gets the parameter number2 from the http request object*/
		int number2 = Integer.parseInt(request.getParameter("number2"));
		int result = 0; //to store the result
		PrintWriter out = response.getWriter(); //writes html file to the client
		switch (operation) {
		case "a"://add
			result = number1 + number2;
			break;
		case "s"://sub
			result = number1 - number2;
			break;
		case "m"://multiply
			result = number1 * number2;
			break;
		case "d"://divide
			if (number2 != 0)
				result = number1 / number2;
			else{//divide by zero case
				out.append("<html>");
				out.append("<body>");
				out.append("<h1>DIVIDE BY ZERO ERROR</h1>");
				out.append("</body>");
				out.append("</html>");
				return;
			}
			break;
		}
		out.append("<html>");
		out.append("<body>");
		out.append("<h1>"+result+"</h1>");
		out.append("</body>");
		out.append("</html>");
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
