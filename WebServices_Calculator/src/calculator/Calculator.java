package calculator;

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
// @WebServlet("/Calculator",urlPatterns={"/Calculator"})
@WebServlet(name = "Calculator", urlPatterns = { "/Calculator" })

public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Calculator() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Integer number1 = Integer.parseInt(request.getParameter("value1"));
			Integer number2 = Integer.parseInt(request.getParameter("value2"));
			PrintWriter printWriter = response.getWriter();
			Float answer = (float) 0;
			char operation = request.getParameter("operation").charAt(0);
			if (operation == '+') {

				answer = (float) (number1 + number2);
				request.setAttribute("result","Answer is" + answer.toString());
				request.getRequestDispatcher("/Calc.jsp").forward(request, response);

			} else if (operation == '-') {
				answer = (float) (number1 - number2);
				request.setAttribute("result", "Answer is" +answer.toString());
				request.getRequestDispatcher("/Calc.jsp").forward(request, response);
			} else if (operation == '*') {
				answer = (float) (number1 * number2);
				request.setAttribute("result","Answer is" + answer.toString());
				request.getRequestDispatcher("/Calc.jsp").forward(request, response);
			} else {
				if (number2 == 0) {
					printWriter.println(
							"<!DOCTYPE html PUBLIC>" + "<html><body>Divide by zero error " + "</body>" + "</html>");
				} else {
					answer = number1 / (float) number2;
					request.setAttribute("result", "Answer is "+answer.toString());
					request.getRequestDispatcher("/Calc.jsp").forward(request, response);
				}
			}

		}

		catch (Exception e) {
			request.setAttribute("result", " wrong input format");
			request.getRequestDispatcher("/Calc.jsp").forward(request, response);
		}
	}
}
