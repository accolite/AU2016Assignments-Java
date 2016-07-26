package com.au;

import java.io.IOException;

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
 * Servlet Filter implementation class ChatFilter
 */
@WebFilter("/SendMsg")
public class ChatFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChatFilter() {
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
		if(session==null){
			chain.doFilter(request, response);
			return;
		}
		ChatBoardData cdata=ChatBoardData.getDataInstance();
		String message=rq.getParameter("message");
		for(String f:cdata.getFilters()){
			message=message.replace(f, "**");
			//System.out.println(f);
		}
		rq.setAttribute("message", message);
		//System.out.println(message);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
