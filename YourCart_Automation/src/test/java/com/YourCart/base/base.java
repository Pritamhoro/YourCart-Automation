package com.YourCart.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base 
{
	WebDriver driver;
	
	public WebDriver IntializeBrowserandOpenApplication() 
	{
		String browser="Chrome";
		
		if(browser.equals("Chrome")) 
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("Edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Internet Explorer")) 
		{
			driver=new InternetExplorerDriver();
		}
		else if(browser.equals("Safari")) 
		{
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		return driver;
	}
}
