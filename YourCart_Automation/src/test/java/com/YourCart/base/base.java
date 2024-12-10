package com.YourCart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class base 
{
	WebDriver driver;
	public Properties prop;
	
	public base() throws IOException
	{
		prop=new Properties();
		File file=new File("./Yourcart/qa/config/config.properties");
		FileInputStream fe=new FileInputStream(file);
		prop.load(fe);
	}
	
	public WebDriver IntializeBrowserandOpenApplication(String browser) 
	{
		
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
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
