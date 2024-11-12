package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet
{
	static int visitorCount = 0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		visitorCount++;
		
		PrintWriter out = response.getWriter();
		
		String clientIp = request.getRemoteAddr();
		out.println("ThirdServlet --- ThirdServlet()----clientIp : " + clientIp+"---"+visitorCount);
		System.out.println("ThirdServlet --- ThirdServlet()----clientIp : " + clientIp+"---"+visitorCount);
	}
}
