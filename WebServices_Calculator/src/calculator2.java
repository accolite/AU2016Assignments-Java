/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 19, 2016

*

*  @author :: Momin Yadav

* ***************************************************************************

*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class calculator2.
 */
@WebServlet("/calculator2")
public class calculator2 extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new calculator 2.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public calculator2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Do post.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int a1 = Integer.parseInt(request.getParameter("n1"));
			int a2 = Integer.parseInt(request.getParameter("n2"));
			if (request.getParameter("r1") != null) {
				out.println("<h1>Result after Addition is </h1>" + (a1 + a2));
			} else if (request.getParameter("r2") != null) {
				out.println("<h1>Result after Substraction is</h1>" + (a1 - a2));
			} else if (request.getParameter("r3") != null) {
				out.println("<h1>Result after  Multiplication- is</h1>" + (a1 * a2));
			}
			// else if(request.getParameter("r4")!=null)
			else {
				if (a2 == 0)
					out.println("can't divide by zero");
				else
					out.println("<h1>Result after Division is </h1>" + (a1 / a2));
			}
		} catch (Exception e) {

		}
	}

	// doGet(request, response);

}
