package com.accolite.chatterbox;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ChatterFilter
 * 
 * This filter looks for invoking of the servlet "Tweet" where we need to make sure the messages is filtered as per the Admin's wish
 * 
 */
@WebFilter(description = "filter class used by admin for filtering chat's words", urlPatterns = { "/tweet" })
public class ChatterFilter implements Filter {
    /**
     * Default constructor. 
     */
    public ChatterFilter() {
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
		//to the session need to cast the request to HttpServletRequest type
		HttpServletRequest rq=(HttpServletRequest)request;
		HttpSession session=rq.getSession(false);
		if(session==null||session.getAttribute("status").equals("loggedout")){
			chain.doFilter(request, response);
			return;
		}
		//session exists and user logged in then apply filter for his message
		ChatterData cdata=ChatterData.getChatterDataInstance();
		String message=rq.getParameter("message");
		for(String f:cdata.getFilters()){
			//find the filter word in the message and convert it into '***'
			message=message.replaceAll(f, "***");
		}
		//set the modified message as message attribute in the request
		rq.setAttribute("message", message);
		//chain it to next filter in the line
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
