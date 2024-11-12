package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

//  Statement-->"SQL Queries Execute"
//    |
// StudentDao--->Student
public class StudentDao 
{
	// Stduent Table----insert SQL
	public  int insertStudent(StudentBean sbean) 
	{
		int  rowAffected = 0 ;
		String insertQuery = "INSERT INTO student(name,std,marks) VALUES ('"+ sbean.getName() +"','"+ sbean.getStd() +"',"+ sbean.getMarks() +")";

		System.out.println("insertQuery : " + insertQuery);
		
		Connection conn = DBConnection.getConnection();
		
		if (conn != null) 
		{
			try 
			{
				Statement stmt = conn.createStatement();
				
				rowAffected = stmt.executeUpdate(insertQuery);
				
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("StudentDao---insertStudent() ---Database not connected");
		}
		return rowAffected;
	}
	public  int updateStudent(StudentBean sbean,int rno) 
	{
		String updateQuery = "UPDATE student SET name='"+sbean.getName()+"', std='"+sbean.getStd()+"', marks="+sbean.getMarks()+" WHERE rno="+rno;

		System.out.println("updateQuery : " + updateQuery);
		
		Connection conn = DBConnection.getConnection();
		
		int rowsAffected = 0 ;

		if (conn!=null) 
		{
			try 
			{
				Statement stmt = conn.createStatement();
				
				rowsAffected = stmt.executeUpdate(updateQuery);
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("StudentDao---updateStudent() Db not connecteed : " + conn);
		}
		
		return rowsAffected;		
	}
	public int deleteStudent(int rno) 
	{
		int rowAffected = 0 ;
		String deleteQuery = "DELETE FROM student WHERE rno = "+rno;
		
		Connection conn = DBConnection.getConnection();
		
		if (conn!=null) 
		{
			try 
			{
				Statement stmt = conn.createStatement();
			
				rowAffected = stmt.executeUpdate(deleteQuery); 
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao---Db not connected : " + conn);
		}
		return rowAffected;
	}
	public ArrayList<StudentBean> getAllStudentsRecords() 
	{
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		String selectQuery = "SELECT  rno,name,std,marks FROM student";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		StudentBean sbean = null;
		if (conn != null) 
		{
			try 
			{
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(selectQuery);
				
				while(rs.next()) 
				{
					int rno		= rs.getInt(1);	
					String name	= rs.getString(2);	
					String std	= rs.getString(3);	
					int marks	= rs.getInt(4);	
					
					sbean = new StudentBean(rno, name, std, marks);
					
					list.add(sbean);
//					System.out.println("===> "+rno+" " + name+" " + std +" " + marks);
				}
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao :: getAllRecords()---Db not connected");
		}
		return list;
	}
	public static void main(String[] args) 
	{
		
		//----------SELECT Student-------------
		
		StudentDao dao = new StudentDao();

		ArrayList<StudentBean> list = dao.getAllStudentsRecords();
		
		System.out.println("list.size() : " + list.size());
		
		
		for (int i = 0; i < list.size(); i++) 
		{
			StudentBean s = list.get(i);
			
			System.out.println(s.getRno()+" " + s.getName()+" " + s.getStd()+" " + s.getMarks());
		}
		//----------UPDATE Student-------------
/*		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Rno which you want to Update : ");
		int rno = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Std : ");
		String std = sc.nextLine();
		System.out.println("Enter Marks : ");
		int marks = sc.nextInt();
		
		StudentDao dao = new StudentDao();
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
		
		int  rowAffected = dao.updateStudent(sbean,rno);
		
		if (rowAffected > 0 ) 
		{
			System.out.println("Student record successfully Updated : " + rowAffected); 
		} else 
		{
			System.out.println("Student record not Updated : " + rowAffected); 
		}
		
		//----------DELETE Student-------------
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Rno which you want to Delete Student record : ");
		int rno = sc.nextInt();
		
		StudentDao dao = new StudentDao();
		
		int rowAffected = dao.deleteStudent(rno);
		
		if (rowAffected > 0 ) 
		{
			System.out.println("Student record successfully Deleted : " + rowAffected); 
		} else 
		{
			System.out.println("Student record not Deleted : " + rowAffected); 
		}
		
		//----------INSERT Student-------------
		
		 * Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Std : ");
		String std = sc.nextLine();
		System.out.println("Enter Marks : ");
		int marks = sc.nextInt();
		
		StudentDao dao = new StudentDao();
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
		
		int  rowAffected = dao.insertStudent(sbean);
		
		if (rowAffected > 0 ) 
		{
			System.out.println("Student record successfully inserted : " + rowAffected); 
		} else 
		{
			System.out.println("Student record not inserted : " + rowAffected); 
		}
		 * */
		
		
		
		
		
		
		
	}
}