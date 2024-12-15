package com.Yourcart.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReporter 
{
	public static void  GenerateExtentReport() 
	{
		ExtentReports extentreports=new ExtentReports();
		File extentReportFile=new File("./test-output/ExtentReport/extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("YourCart ecommerce automation");
		spark.config().setDocumentTitle("YourCart");
		spark.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentreports.attachReporter(spark);
		
		extentreports.setSystemInfo("Application URL ", "https://naveenautomationlabs.com/opencart");
		extentreports.setSystemInfo("Broswer ", "Chrome");
			

	}
}
