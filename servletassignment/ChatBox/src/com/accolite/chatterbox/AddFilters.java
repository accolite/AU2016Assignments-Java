package com.accolite.chatterbox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddFilters
 */
@WebServlet(description = "adding filters as admin says", urlPatterns = { "/addfilters" })
public class AddFilters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChatterData cdata=ChatterData.getChatterDataInstance();
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("status").equals("loggedout")){
			response.sendRedirect("error.html");
			return;
		}
		if(session.getAttribute("username").equals("admin"))
			cdata.addFilter(request.getParameter("filters"));
		response.sendRedirect("admin.html");
	}

}
