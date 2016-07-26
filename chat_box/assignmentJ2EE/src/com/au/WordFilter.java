package com.au;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class WordFilter
 */
@WebFilter(description = "filter the prohibited words", urlPatterns = { "/home" })
public class WordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WordFilter() {
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
		int i;
		String msg = request.getParameter("message");
		for(i = 0; i < AdminUserServlet.words.size(); i++) {
			System.out.println("word at "+ i + " : " + AdminUserServlet.words.get(i));
			msg = msg.replace(AdminUserServlet.words.get(i), " * ");
			System.out.println("intermediate : " + msg);
			
		}
		request.getServletContext().setAttribute("userMessage", msg);
		System.out.println("final msg : " + msg);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
