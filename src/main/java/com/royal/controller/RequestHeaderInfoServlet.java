package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestHeaderInfoServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		System.out.println("headerName-----headerValue");

		Enumeration<String>  headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) 
		{
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			
			out.println("<b>"+headerName+"</b>-----"+headerValue+"<br>");
		}
		
//		String connection = request.getHeader("connection");
//		String user_agent = request.getHeader("user-agent");
//		String accept_language = request.getHeader("accept-language");
		
//		System.out.println("host : " + host);
//		System.out.println("connection : " + connection);
//		System.out.println("user_agent : " + user_agent);
//		System.out.println("accept_language : " + accept_language);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
