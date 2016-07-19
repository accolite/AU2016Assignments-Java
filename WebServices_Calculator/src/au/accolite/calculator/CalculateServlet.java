/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Diksha Garg

* ***************************************************************************

*/
package au.accolite.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Calculator.
 */
@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new calculate servlet.
     *
     * @see HttpServlet#HttpServlet()
     */
    public CalculateServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int input1=Integer.parseInt(request.getParameter("display1"));
		//out.println(input1);
		
		int input2=Integer.parseInt(request.getParameter("display2"));
		//out.println(input2);
		
		String operation=request.getParameter("option");
		//out.println(operation);
		
		int result;
		
		out.println("Number 1: "+input1);
		out.println("<br/>");
		out.println("Number 2: "+input2);
		out.println("<br/>");
		
		if(operation.equals("add"))
		{
			result=input1+input2;
			out.println(result);
			
		}
		
		if(operation.equals("subtract"))
		{
			result=input1-input2;
			out.println(result);
		}
		
		if(operation.equals("multiply"))
		{
			
			result=input1*input2;
			out.println(result);
		}
		
		if(operation.equals("divide"))
		{
			try {
				
				float resultF=(float)input1/(float)input2;
				out.println(resultF);
			} catch (Exception e) {
				out.println("Cannot divide by zero!!!!!");
			}
			
		}
		
        
	}

}
