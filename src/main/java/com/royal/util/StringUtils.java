package com.royal.util;

public class StringUtils 
{
	public static boolean isValidString(String value) 
	{
//		if ((value.trim().length() > 0) && (value != null)) 
//		{
//			return true;
//		} 
//		return false;
		
		return ( ((value.trim().length() > 0) && (value != null))) ? true : false ;
	}
}
