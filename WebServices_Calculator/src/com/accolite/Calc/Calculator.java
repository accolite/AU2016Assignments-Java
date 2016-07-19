/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Jul 19, 2016
*
*  @author :: Jegan Muthaiah
* ***************************************************************************
*/
package com.accolite.Calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class calculator.
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new calculator.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Gets the request from client
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Server Response:"+response.getStatus());
		doPost(request,response);
	}

	/**
	 * Post the value in web page 
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter output=response.getWriter();
		output.println("Result");
		String number1,number2,operator;
		number1=request.getParameter("num1");
		number2=request.getParameter("num2");
		operator=request.getParameter("operator");
		if(operator.equalsIgnoreCase("addition")){
			output.println("<h5>Addition:</h5>"+ (Integer.parseInt(number1)+Integer.parseInt(number2)));
		}
		else if(operator.equalsIgnoreCase("subtraction")){
			 output.println("<h1>Subtraction</h1>"+(Integer.parseInt(number1) - Integer.parseInt(number2)));
		}
		else if(operator.equalsIgnoreCase("multiplication")){
            output.println("<h1>Multiplication</h1>"+(Integer.parseInt(number1) * Integer.parseInt(number2)));
		}
		else if(operator.equalsIgnoreCase("division")){
            try{
            	output.println("<h1>Division</h1>"+(Integer.parseInt(number1) / Integer.parseInt(number2)));
            }catch(Exception e){
            	output.println("Exception:Division by zero");
            	System.out.println("Division by zero");
            }
		}
		
		
	}

}
