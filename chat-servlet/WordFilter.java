package com.accolite.servletAssignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

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
@WebFilter(description = "filters prohibited words", urlPatterns = { "/sendMessage" })
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

		System.out.println("in word filter");
		
		String message = request.getParameter("message");
		
		System.out.println("message is"+message);
		StringTokenizer stringTokenizer = new StringTokenizer(message);
		
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		
		int count = stringTokenizer.countTokens();
		String[] messageWords = new String[count];
		
		int i = 0;
		while(stringTokenizer.hasMoreTokens()){
			messageWords[i] = stringTokenizer.nextToken();
			i++;
		}
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select word from  prohwords");
			ResultSet rs =  preparedStatement.executeQuery();
			
			while(rs.next()){
				String proword = rs.getString(1);
				i = 0;
				while(i < count){
					if(proword.equals(messageWords[i]))
						messageWords[i] = "";
					i++;
				}
			}
			
			message = "";
			i = 0;
			while(i <count){
				message = message +" "+ messageWords[i];
				i++;
			}
			
			System.out.println("final message:"+message);
			
			request.setAttribute("message", message);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
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
