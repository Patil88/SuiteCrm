package com.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBaseClass;

public class LoginPage extends TestBaseClass
{
	//initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//----------obj repo--------
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='login-button']")
	private WebElement loginBtn;
	
	
	//-----------Action Method-------
	public void enterUserName(String Username) 
	{
		username.sendKeys(Username);
	}
	public void enterPassword(String Password) 
	{
		password.sendKeys(Password);
	}
	public void clickOnLoginBtn() 
	{
		loginBtn.click();
	}
}
