package com.YourCart.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		String actualProduct=driver.findElement(By.xpath("//a[contains(text(),'iPhone')]")).getText();
		Assert.assertEquals(actualProduct, "iPhone","Product is out of stock");
	}
	
	@Test
	public void SearchInValidProduct() 
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("IQOO");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
		String actualResult=driver.findElement(By.xpath("//p[contains(text(),'There is no product')]")).getText();
		String expectedResult="There is no product that matches the search criteria.";
		Assert.assertEquals(actualResult, expectedResult,"Product is out of stock");
	}
}
