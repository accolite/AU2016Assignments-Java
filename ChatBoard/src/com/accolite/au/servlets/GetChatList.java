package com.accolite.au.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetChatList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletConfig().getServletContext();

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login.html");

		} else {
			ArrayList<String> list = (ArrayList<String>) context.getAttribute("userlist");
			
			String all = " ";

			if (list == null) {
				context.setAttribute("userlist", new ArrayList<String>());
			} else {
				for (String i : list) {

					all = all + "\n" + i;

				}

				response.getWriter().write(all);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
