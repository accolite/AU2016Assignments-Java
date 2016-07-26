package com.au;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adminthings
 */
@WebServlet("/Adminthings")
public class Adminthings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminthings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String choice=request.getParameter("choice");
		String s="";
		String n="";
		s=(String) request.getSession().getAttribute("uname");
		n=(String) request.getSession().getAttribute("pw");
		if(choice.equals("load")){
			System.out.println(s);
			if(s.equals("")||s.equals("null")){
				
			}
			else{
				if(s.equals(tempstuffs.getAdmin()[0])&&s.equals(tempstuffs.getAdmin()[0])){
					s.indexOf("");
				}
			}
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
