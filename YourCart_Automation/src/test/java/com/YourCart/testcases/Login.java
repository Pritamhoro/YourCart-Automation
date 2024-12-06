package com.YourCart.testcases;

import java.sql.Date;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Yourcart.utilities.Utilities;

public class Login 
{
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() 
	{
		String BroswerName="Firefox";
		if(BroswerName.equals("Chrome") )
		{
			driver=new ChromeDriver();
		}
		else if(BroswerName.equals("Edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(BroswerName.equals("Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(BroswerName.equals("Safari")) 
		{
			driver=new SafariDriver();
		}
		else if(BroswerName.equals("InternetExplorer")) 
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	}
	@AfterMethod
	public void TearDown() 
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void LoginwithValidData() 
	{
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ketif98663@ikowat.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ketif98663");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit yout account is not displaying");		
	}
	
	@Test(priority=2)
	public void LoginwithInValidData() 
	{
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys(Utilities.GenearteEmailwithTimeStamp());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("keti");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	
	public String generateTimeStamp() 
	{
		Date date=new Date(10);
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	@Test(priority=3)
	public void LoginwithInvalidEmail() 
	{
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys(Utilities.GenearteEmailwithTimeStamp());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ketif98663");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=4)
	public void LoginwithInvalidPassword() 
	{
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("ketif98663@ikowat.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("keti");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=5)
	
	public void LoginWithEmptyFileds() 
	{
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");

	}
}
