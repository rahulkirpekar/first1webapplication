package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SevenServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// SevenServlet ---config---> ?
		ServletConfig config = getServletConfig();
		
		//String lang1 = config.getInitParameter("lang1");
		//String lang2= config.getInitParameter("lang2");
		//String lang3= config.getInitParameter("lang3");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<b>"+config.getServletName()+" : </b><br>");
		
		Enumeration<String> paramNames = config.getInitParameterNames();
		
		while(paramNames.hasMoreElements()) 
		{
			String paramName = paramNames.nextElement();
			
			String paramValue = config.getInitParameter(paramName);
			
			out.print("<b>"+paramName+" : </b>" + paramValue+"<br>");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}