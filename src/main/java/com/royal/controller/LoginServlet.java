package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.util.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	// Get---request
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");// admin
		String password = request.getParameter("password");// admin@123
		
		RequestDispatcher rd = null;
		
		if (  (StringUtils.isValidString(userName)) && ( (StringUtils.isValidString(password))))
		{
			if(userName.equals("admin") && password.equals("admin@123")) 
			{
				rd = request.getRequestDispatcher("register.html");
			}else 
			{
				rd = request.getRequestDispatcher("login.html");
			}
		}else
		{
			rd = request.getRequestDispatcher("login.html");
		}
		rd.forward(request, response);
	}
	// post---request
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}