package com.YourCart.testcases;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.YourCart.base.base;
import com.Yourcart.qa.pages.HomePage;
import com.Yourcart.qa.pages.LoginPage;
import com.Yourcart.utilities.Utilities;

import net.bytebuddy.implementation.bind.annotation.Super;

public class Login extends base
{
	WebDriver driver;
	public Login() throws IOException 
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() 
	{
		driver=IntializeBrowserandOpenApplication();
		HomePage homepage=new HomePage(driver);
		homepage.ClickOnMyAccount();
		homepage.ClickonLoginButton();
	}
	@AfterMethod
	public void TearDown() 
	{
		driver.quit();
	}
	
	@Test(priority = 1, dataProvider = "supplyTestData")
	public void LoginwithValidData(String Email, String Password) 
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(Email);
		loginpage.enterPassword(Password);
		loginpage.ClickonLoginButton();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit yout account is not displaying");		
	}
	
	@DataProvider
	public  Object [] [] supplyTestData() throws IOException 
	{
		Object [] [] data=Utilities.GetTestDataFromExecl("Login");
		return data;
	
	}
	
//	@DataProvider
//	public  Object [] [] supplyTestData() 
//	{
//		Object [] [] data=new Object[] [] {{"ketif98663@ikowat.com", "ketif98663"},
//											{"ketif9866@ikowat.com", "ketif98663"} , 
//											{"ketif983@ikowat.com", "ketif98663"}};
//			return data;
//	
//	}
//	
	
	@Test(priority=2)
	public void LoginwithInValidData() 
	{
		driver.findElement(By.id("input-email")).sendKeys(Utilities.GenearteEmailwithTimeStamp());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("keti");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test(priority=3)
	public void LoginwithInvalidEmail() 
	{
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
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ActualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		String expectedWariningMessage=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertFalse(ActualWarningMessage.contains(expectedWariningMessage), "Warning: No match for E-Mail Address and/or Password.");

	}
}
