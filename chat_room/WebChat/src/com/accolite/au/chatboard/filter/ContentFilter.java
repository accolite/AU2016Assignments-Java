package com.accolite.au.chatboard.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// TODO: Auto-generated Javadoc
/**
 * Servlet Filter implementation class ContentFilter.
 */
@WebFilter("/post")
public class ContentFilter implements Filter {
	
	/** The config. */
	FilterConfig config;
    /**
     * Default constructor. 
     */
    public ContentFilter() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Gets the config.
     *
     * @return the config
     */
    public FilterConfig getConfig() {
		return config;
	}

	/**
	 * Sets the config.
	 *
	 * @param config the new config
	 */
	public void setConfig(FilterConfig config) {
		this.config = config;
	}

	/**
	 * Destroy.
	 *
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Do filter.
	 *
	 * @param request the request
	 * @param response the response
	 * @param chain the chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String[] wordslist = (String[])this.getConfig().getServletContext().getAttribute("wordslist");
		String msg = request.getParameter("msg");
		if(wordslist!=null){
			for(String word: wordslist){
				if(!word.trim().equals("")){
					msg = msg.replaceAll(word.trim(), " ");
					System.out.println(word+" is removed");
					System.out.println(msg);
				}
			}
		}
		request.setAttribute("msg", msg);
		chain.doFilter(request, response);
	}



	/**
	 * Inits the.
	 *
	 * @param fConfig the f config
	 * @throws ServletException the servlet exception
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		setConfig(fConfig);
	}

}
