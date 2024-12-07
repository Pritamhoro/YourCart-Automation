package com.YourCart.testcases;

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

import com.YourCart.base.base;
import com.Yourcart.utilities.Utilities;

public class Register extends base
{
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetup() 
	{
		driver=IntializeBrowserandOpenApplication();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}
	
	@AfterMethod
	public void tear_down() 
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void RegisterwithAllMandatoryFiled() 
	{
		driver.findElement(By.id("input-firstname")).sendKeys("Pritam");
		driver.findElement(By.id("input-lastname")).sendKeys("H");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.GenearteEmailwithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("999822555");
		driver.findElement(By.id("input-password")).sendKeys("Pritam@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Pritam@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String Success=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		String Congratulations=driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		
		
		Assert.assertEquals("Your Account Has Been Created!", Success, "Account Success Page is not displayed");
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", Congratulations, "Account Success Page is not displayed");
		
	}
	
	@Test(priority = 2)
	public void verifyRegisterAccountByProvidingAllfiled() 
	{
	
		driver.findElement(By.id("input-firstname")).sendKeys("Pritam");
		driver.findElement(By.id("input-lastname")).sendKeys("H");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.GenearteEmailwithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("999822555");
		driver.findElement(By.id("input-password")).sendKeys("Pritam@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Pritam@123");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String Success=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		String Congratulations=driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		
		
		Assert.assertEquals("Your Account Has Been Created!", Success, "Account Success Page is not displayed");
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", Congratulations, "Account Success Page is not displayed");
		
	}
	
	@Test(priority = 3)
	public void verifyRegisterAccountByexitingemail() 
	{
		
		driver.findElement(By.id("input-firstname")).sendKeys("Pritam");
		driver.findElement(By.id("input-lastname")).sendKeys("H");
		driver.findElement(By.id("input-email")).sendKeys("ketif98663@ikowat.com");
		driver.findElement(By.id("input-password")).sendKeys("Pritam@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Pritam@123");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String WarningforExitingEmail=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	
		Assert.assertEquals("Warning: E-Mail Address is already registered!", WarningforExitingEmail, "Error message is not displaying.");
	}

}
