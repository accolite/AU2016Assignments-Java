package com.accolite.ServletAssignMent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
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
		String ans = null;
		float first_number;
		float second_number;
		try {
			first_number = Float.valueOf(request.getParameter("first_number"));
			second_number = Float.valueOf(request.getParameter("second_number"));
			if (request.getParameter("Add") != null)
				ans = String.valueOf(add(first_number, second_number));
			if (request.getParameter("mul") != null)
				ans = String.valueOf(mul(first_number, second_number));
			if (request.getParameter("div") != null) {
				try {
					ans = String.valueOf(div(first_number, second_number));
				} catch (ArithmeticException ex) {
					ans = "Can not divide by zero";
				}
			}
			if (request.getParameter("sub") != null)
				ans = String.valueOf(sub(first_number, second_number));
		}

		catch (NumberFormatException e) {
			ans = "Choose Valid Inputs";
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>" + ans + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	private float sub(float first_number, float second_number) {
		// TODO Auto-generated method stub
		return first_number - second_number;
	}

	private float div(float first_number, float second_number) throws ArithmeticException {
		// TODO Auto-generated method stub
		return first_number / second_number;
	}

	private float mul(float first_number, float second_number) {
		// TODO Auto-generated method stub
		return first_number * second_number;
	}

	private float add(float first_number, float second_number) {
		// TODO Auto-generated method stub
		return first_number + second_number;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
