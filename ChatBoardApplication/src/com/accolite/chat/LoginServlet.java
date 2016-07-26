package com.accolite.chat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int fl=0;
		//System.out.println();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(response);
		String s1=request.getParameter("name");
		String s2=request.getParameter("password");
		System.out.println(s1+" "+s2);
		for (String key : MapGlobal.registeredUsers.keySet())
		{
			if(key.equals(s1)&&MapGlobal.registeredUsers.get(key).equals(s2))
			{
				
				fl=2;
				break;
			}
			
				
		}
		if(fl==0)
		{
			System.out.println("Invalid Login");
			response.sendRedirect("MainScreen.html");
		}
		else 
		{
			
		
				MapGlobal.activeUsers.put(s1, s2);
				HttpSession session=request.getSession(true);
				MapGlobal.chatsRecord.add("<br>"+s1+" logged in");
				session.setAttribute("name", s1);
				response.sendRedirect("ChatRoom.jsp");
				
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
