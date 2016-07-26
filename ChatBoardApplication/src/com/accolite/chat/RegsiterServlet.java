package com.accolite.chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

/**
 * Servlet implementation class RegsiterServlet
 */
@WebServlet("/RegsiterServlet")
public class RegsiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegsiterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int fl=0;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String s1=request.getParameter("name");
		String s2=request.getParameter("password");
		for (String key : MapGlobal.registeredUsers.keySet())
		{
			if(key.equals(s1))
			{
				System.out.println("Enter unique name");
				fl=1;
				break;
			}
		
				
		}
		if(fl==0)
		{
			MapGlobal.registeredUsers.put(s1, s2);
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
