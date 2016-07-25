package com.accolite.servletassignment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AllUsers
 */
@WebServlet("/AllUsers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> map = new HashMap<>();
		if(getServletContext().getAttribute("logged_in")==null){
        	map.put("-1", "Invalid request");
        }else{
        	Map<String, String> logged_in = (Map<String, String>) getServletContext().getAttribute("logged_in");
        	for(String id: logged_in.keySet()){
        		map.put(id, logged_in.get(id));
        	}
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
