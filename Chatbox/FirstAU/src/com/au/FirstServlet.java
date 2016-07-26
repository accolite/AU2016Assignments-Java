package com.au;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(
		description = "Desc First Servlet", 
		urlPatterns = { "/FirstServlet" }, 
		initParams = { 
				@WebInitParam(name = "fname", value = "au2016", description = "something related to desc")
		})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session==null){
			session = request.getSession();
			session.setAttribute("user", "validUser");
		}
		
		String s1 = request.getParameter("age");
		PrintWriter pw = response.getWriter();
		pw.append("Served at: ").append(request.getContextPath()+"\n");
		Enumeration<String> headers = request.getHeaderNames();
		StringBuilder sb = new StringBuilder();
		while(headers.hasMoreElements()){
			String temp = headers.nextElement();
			sb.append(temp);
			sb.append("=");
			sb.append(request.getHeader(temp));
			sb.append("\n");
		}
		sb.append("ctxtAttr= "+getServletContext().getAttribute("ctxtAttr"));
		sb.append("age= "+s1);
		pw.append(sb);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
