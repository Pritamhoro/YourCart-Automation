package com.Yourcart.utilities;



import java.util.Date;

import org.testng.annotations.Test;

public class Utilities 
{
	public static final int IMPLICIT_WAIT_TIME =10;
	public static final int PAGE_LOAD_TIME=10;
	
	@Test
	public static String  GenearteEmailwithTimeStamp() 
	{
		Date date=new Date();
		String middle=date.toString().replace(" ", "_").replace(":", "_");
		return "Pritam"+middle + "H" +"@gmail.com";
	}
}
