package com.accolite.servletassignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Blocked
 */
@WebServlet("/Blocked")
public class Blocked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Blocked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletContext().getAttribute("blocked")==null){
			request.getServletContext().setAttribute("blocked", new ArrayList<String>());
		}
		String local = (String) request.getParameter("blocked");
		System.out.println("Local is here:"+local);
		List<String> blocked_local = Arrays.asList(local.split("\\s*,\\s*"));;
		List<String> blocked_global = (List<String>) request.getServletContext().getAttribute("blocked");
		blocked_global = new ArrayList<>();
		blocked_global.addAll(blocked_local);
		request.getServletContext().setAttribute("blocked", blocked_global);
		System.out.println("Blocked GLobal : "+blocked_global);
	}

}
