package com.YourCart.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.YourCart.base.base;

public class Search extends base
{
	WebDriver driver;
	@BeforeMethod
	public void Browser_Setup() 
	{
		driver=IntializeBrowserandOpenApplication();		
	}
	
	@AfterMethod
	public void TearDown() 
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void SearchValidProduct() 
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("I Phone");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	}
}
