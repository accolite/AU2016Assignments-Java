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
		HttpServletRequest rq=(HttpServletRequest)request;
		HttpSession session=rq.getSession(false);
		if(session==null||session.getAttribute("status").equals("loggedout")){
			chain.doFilter(request, response);
			return;
		}
		ChatterData cdata=ChatterData.getChatterDataInstance();
		String message=rq.getParameter("message");
		Enumeration<String> en=rq.getParameterNames();
		while(en.hasMoreElements())
			System.out.println(en.nextElement());
		System.out.println(message+" "+rq.getAttribute("message"));
		for(String f:cdata.getFilters()){
			message.replaceAll(f, "***");
		}
		rq.setAttribute("message", message);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
