package com.Yourcart.utilities;

import java.sql.Date;

public class Utilities 
{
	public static String GenearteEmailwithTimeStamp() 
	{
		Date date=new Date(10);
		String middle=date.toString().replace(" ", "_").replace(":", "_");
		return "Pritam"+middle + "H" +"@gmail.com";
		
	}
}
