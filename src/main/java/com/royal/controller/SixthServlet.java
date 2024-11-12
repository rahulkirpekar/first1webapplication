package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SixthServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// SixthServlet ---config---> ?
		ServletConfig config = getServletConfig();
		
		String urlName = config.getInitParameter("URLNAME");
		String driverClass = config.getInitParameter("DRIVERCLASS");
		String userName = config.getInitParameter("USERNAME");
		String password = config.getInitParameter("PASSWORD");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<b>"+config.getServletName()+" : </b><br>");
		
		out.print("<b>UrlName : </b>" + urlName+"<br>");
		out.print("<b>driverClass : </b>" + driverClass+"<br>");
		out.print("<b>UserName : </b>" + userName+"<br>");
		out.print("<b>password : </b>" + password+"<br>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
