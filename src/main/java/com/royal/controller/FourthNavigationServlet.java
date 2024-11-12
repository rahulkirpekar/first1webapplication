package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FourthNavigationServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("FourthNavigationServlet :: doGet()---Hello");
		
		
//		request.getRequestDispatcher("[urlPattern]---Servlet / XXX.html / XXX.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("fifthNavigation");
		
//		rd.forward(request, response);
		rd.include(request, response);
		
	} 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);	
	}
}
/*
request navigation:-
--------------------

			login.html


	servlet1	servlet2	servlet3	servlet4	

	1) request--->
			requestdispacher
				1) forward
				2) include

login.html----LoginServlet--get------InsertStudnetServlet---request---data get



	2) response--->sendredirect

*/