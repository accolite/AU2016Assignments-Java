/*
 * /****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Loghithavani

* ***************************************************************************

 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer val1 = Integer.parseInt(request.getParameter("Value1"));
		Integer val2 = Integer.parseInt(request.getParameter("Value2"));
		String option = request.getParameter("Option");
		Integer answer = null;
		
		if(option.equals("Add")){
			answer = val1+val2;
		}
		else if(option.equals("Subtract")){
			answer = val1-val2;
		}
		else if(option.equals("Multiply")){
			answer = val1*val2;
		}
		else if(option.equals("Divide")){
			answer = val1/val2;
		}
		System.out.println("Answer is:"+answer);
		request.setAttribute("result", answer.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In post method");
		doGet(request, response);
	}

}
