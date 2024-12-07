package com.Yourcart.utilities;



import java.util.Date;

import org.testng.annotations.Test;

public class Utilities 
{
	@Test
	public static String  GenearteEmailwithTimeStamp() 
	{
		Date date=new Date();
		String middle=date.toString().replace(" ", "_").replace(":", "_");
		return "Pritam"+middle + "H" +"@gmail.com";
		
		
		
	}
}
