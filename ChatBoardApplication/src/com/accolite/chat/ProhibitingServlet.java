package com.accolite.chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProhibitingServlet
 */
@WebServlet("/ProhibitingServlet")
public class ProhibitingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProhibitingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str=request.getParameter("prohibitedwords");
		String inp="";
		int i=0;
		
		while(i<str.length())
		{
			while(i<str.length()&&str.charAt(i)!=',')
			{
				
				inp+=str.charAt(i);
				i++;
				System.out.println(inp);
			}
			MapGlobal.prohibitedWords.add(inp);
			inp="";
			i++;
		}
		response.sendRedirect("MainScreen.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
