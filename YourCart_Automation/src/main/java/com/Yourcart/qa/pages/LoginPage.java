package com.Yourcart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement EmailFiled;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LoginCTAButton;
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	public void enterEmailAddress(String Email) 
	{
		EmailFiled.sendKeys(Email);
	}
	
	public void enterPassword(String Password)
	{
		PasswordField.sendKeys(Password);
	}
	
	public void ClickonLoginButton() 
	{
		LoginCTAButton.click();
	}
}
