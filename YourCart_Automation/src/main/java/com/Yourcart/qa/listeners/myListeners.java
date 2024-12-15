package com.Yourcart.qa.listeners;

import java.sql.ResultSet;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentReporter;

public class myListeners implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Project execution stared ");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String testresult=result.getName();
		System.out.println( "Start executing "+testresult);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String testresult=result.getName();
		System.out.println( "Execution failed  "+testresult);
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String testresult=result.getName();
		System.out.println( " Execution TestSkipped "+testresult);
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Finished executing project tests");
	}
	
}