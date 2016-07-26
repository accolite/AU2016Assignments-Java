package com.accolite.au.chatboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class Admin.
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new admin.
     *
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
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
		
		if(request.getSession().getAttribute("admin")!=null){
			String words = request.getParameter("words").trim();
			System.out.println(words);
			String[] wordslist = words.split(",");
			for(String word: wordslist){
				System.out.println(word);
			}
			getServletConfig().getServletContext().setAttribute("wordslist", wordslist);
			response.sendRedirect("/WebChat/admin.jsp");
		}
		else{
			response.setContentType("text/html");
			response.getWriter().write("Not a valid operation. <a href=\"/WebChat/\">Login</a> please");
		}
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
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		if(user.equals("admin") && password.equals("admin")){
			request.getSession().setAttribute("admin", true);
			response.sendRedirect("/WebChat/admin.jsp");
		}
		response.setContentType("text/html");
		response.getWriter().write("Login invalid. <a href=\"/WebChat/\">Try</a> again");
	}
}


