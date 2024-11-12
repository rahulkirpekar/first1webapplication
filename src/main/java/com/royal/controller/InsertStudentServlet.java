package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet  extends HttpServlet
{
	ArrayList<StudentBean> list = new ArrayList<StudentBean>();
	
	int rno = 1;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("InsertStudentServlet :: doGet()");
		// get All parameters from request
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String hbValues[]=request.getParameterValues("hobbies");
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hbValues.length; i++) 
		{
			if(i < (hbValues.length-1)) 
			{
				sb.append(hbValues[i]+", ");
			}else 
			{
				sb.append(hbValues[i]+".");
			}
		}
		
		String hobbies = sb.toString();// [Sports,Reading.]
		
		StudentBean sbean = new StudentBean(rno,firstName, middleName, lastName, dob, gender, hobbies, address, state);
		
		list.add(sbean);

		
		request.setAttribute("listOfStudents", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("listStudent");
		rd.forward(request, response);
//		rd.include(request, response);
		
		rno++;
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);	
	}
}