package com.saas.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saas.base.BaseTest;
import com.saas.utills.Constants;


public class LoginPageTest extends BaseTest{
		
	@Test(priority = 1)
	public void verifyLoginUser() {
		String user= homePage.getUserNameFromHomePage();
		System.out.println("User logged in is - "+user);
		Assert.assertTrue(user.contains(prop.getProperty("username").split("[.]", 0)[0]));
	}
}
