package com.YourCart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import com.Yourcart.utilities.Utilities;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class base 
{
	WebDriver driver;
	public Properties prop;
	public base() throws IOException 
	{
		prop=new Properties();
		FileInputStream fe=new FileInputStream("./src/main/java/com/Yourcart/qa/Config/config.properties");
//		File file=new File(System.getProperty("user.dir")+"./Yourcart/qa/Config/config.properties");
		prop.load(fe);

}
	public WebDriver IntializeBrowserandOpenApplication() 
	{
		String browser=prop.getProperty("browserName");
		
		if(browser.equalsIgnoreCase("Chrome")) 
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Internet Explorer")) 
		{
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("Safari")) 
		{
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("URL"));
		
		return driver;
	}
}
