package com.Yourcart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountButton;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement LoginButton;
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Action 
	public void ClickOnMyAccount()
	{
		MyAccountButton.click();
	}
	
	
	public void ClickonLoginButton() 
	{
		LoginButton.click();
	}
}
