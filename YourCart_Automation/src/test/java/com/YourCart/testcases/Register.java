package com.YourCart.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Yourcart.utilities.Utilities;

public class Register 
{
	WebDriver driver;
	
	@AfterMethod
	public void tear_down() 
	{
		driver.quit();
	}
	
	@Test
	public void RegisterwithAllMandatoryFiled() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
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

}
