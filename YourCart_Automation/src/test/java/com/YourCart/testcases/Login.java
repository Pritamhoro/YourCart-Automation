package com.YourCart.testcases;

import java.sql.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login 
{
	@Test
	public void LoginwithValidData() 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ketif98663@ikowat.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ketif98663");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit yout account is not displaying");
		
		driver.quit();
		
	}
	
	@Test
	public void LoginwithInValidData() 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart//");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ketif"+generateTimeStamp()+"@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("keti");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
		driver.quit();
		
	}
	
	public String generateTimeStamp() 
	{
		Date date=new Date(10);
		return date.toString().replace(" ", "_").replace(":", "_");
	}
}
