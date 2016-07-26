package com.chatapp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class BannedWordFilter
 */
@WebFilter("/ChatString")
public class BannedWordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BannedWordFilter() {
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
		String message = request.getParameter("message");
		ServletContext context = request.getServletContext();
		String words = (String) context.getAttribute("BannedWords");
		if( message != null && words != null )
		{
			String[] wordsArray = words.split(",");
			for (int b = 0; b < wordsArray.length; b++) {
				message = message.replaceAll( wordsArray[b], "");
			}
			request.setAttribute("Fmsg", message);
			chain.doFilter( request, response);
		}
		else
		{
			request.setAttribute("Fmsg", message);
			chain.doFilter( request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
