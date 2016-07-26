package com.au;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static StringBuilder msg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String app = request.getParameter("message");
		String user = request.getParameter("user");
		//StringBuilder msg = (StringBuilder) request.getServletContext().getAttribute("message");
		String usermsg = (String) getServletContext().getAttribute("userMessage");
		if(usermsg != "") {
			HttpSession session = request.getSession();
			String uname = (String) session.getAttribute("username");
			
			if(msg == null)
				msg = new StringBuilder("\n" + uname + ": " + usermsg);
			else
				msg.append("\n\n" + uname + ": " + usermsg);
			System.out.println("message in home : " + msg);
			response.getWriter().println(msg);
		}
		response.getWriter().println("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
