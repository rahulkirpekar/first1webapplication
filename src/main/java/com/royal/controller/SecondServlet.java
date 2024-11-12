package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet 
{
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		System.out.println("SecondServlet :: init(ServletConfig config)---"+this);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("SecondServlet :: service()---"+this);
		
		ServletContext context = getServletContext();
		
		String urlName = context.getInitParameter("URLNAME");
		String driverClass = context.getInitParameter("DRIVERCLASS");
		String userName = context.getInitParameter("USERNAME");
		String password = context.getInitParameter("PASSWORD");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>SecondServlet : </b><br>");
		
		out.print("<b>urlName</b> : " +urlName +"<br>");
		out.print("<b>driverClass</b> : " +driverClass +"<br>");
		out.print("<b>userName   </b> : " +userName   +"<br>");
		out.print("<b>password   </b> : " +password   +"<br>");
	}
	@Override
	public void destroy() 
	{
		System.out.println("SecondServlet :: destroy()---"+this);
	}
}
