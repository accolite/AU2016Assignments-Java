package com.accolite.servletassignment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Map<String, String> map = new HashMap<>();
		if(session!=null){
			/**
			 * If session available
			 */
			session.invalidate();
			map.put("status", "true");
			map.put("content", "logged out");
		}else{
			map.put("status", "false");
			map.put("content", "failed to retrieve session");
		}
		String json = new Gson().toJson(map);
    	/**
    	 * Return JSON of status using GSON
    	 */
		
    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(json); 
	}

}
