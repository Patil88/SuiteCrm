package com.TestLayer;

import org.testng.annotations.Test;

import com.TestBase.TestBaseClass;

public class LoginTest extends TestBaseClass
{
	@Test
	public void verifyLoginFunctionality() 
	{
		login.enterUserName("will");
		login.enterPassword("will");
		login.clickOnLoginBtn();
	}
}
