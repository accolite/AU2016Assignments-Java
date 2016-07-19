package com.accolite.calculator;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@SuppressWarnings("serial")


@WebServlet("/Calculator")
public class Calculator extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		int number1= Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		String operator = request.getParameter("operator");
		int result = 0;
		switch(operator)
		{
		case "sum":
			result=number1 + number2;
			break;
		case "difference":
			result = number1 - number2;
			break;
		case "product":
			result = number1 * number2;
			break;
		case "divide":
			try{
				result= number1 / number2;
			}
			catch(ArithmeticException e)
			{
				result=0;
				System.out.println("divide by zero");
			}
			break;
		}
		
		request.setAttribute("result", result); 
	    request.getRequestDispatcher("Welcome.jsp").forward(request, response);
	}
}
