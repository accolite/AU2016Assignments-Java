package com.au.servletandjsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TextFilter
 */
@WebFilter("/TextFilter")
public class TextFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TextFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		List<String> blockedList=AdminServlet.blockedWords;
		  String userMsg = request.getParameter("myText");
		  
		  for(int i = 0; i < blockedList.size(); i++) {
			  userMsg=userMsg.replace(blockedList.get(i), " * ");
			 System.out.println(userMsg);
			//  System.out.println(blockedList.size());
			//  System.out.println(blockedList.get(i));
		  }
		  
		  request.getServletContext().setAttribute("userText", userMsg);

		  System.out.println("final msg : " + userMsg);
		 // response.getWriter().println(userMsg);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
