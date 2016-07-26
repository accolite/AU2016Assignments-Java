package com.accolite.filters;

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
 * Servlet Filter implementation class BannedFilter
 */
@WebFilter("/SendMessage")
public class BannedFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BannedFilter() {
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
		String msg = request.getParameter("txtMessage");
		List<String> bannedWords = (List<String>) request.getServletContext().getAttribute("bannedWords");
		if(bannedWords != null && msg != null){
				
			for (String word : bannedWords) {
				msg = msg.replace(word, "");
			}
			
		}
		request.setAttribute("txtMessage", msg);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
