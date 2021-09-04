package com.saas.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saas.factory.DriverFactory;
import com.saas.pages.HomePage;
import com.saas.pages.LoginPage;
import com.saas.reporting.TestAllureListener;
import com.saas.utills.Constants;

@Listeners(TestAllureListener.class)
public class BaseTest {

	DriverFactory df;	
	WebDriver driver;
	public Properties prop;
	
	public LoginPage loginPage;
	public HomePage homePage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", browserName);
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
		verifyLoginPageTitle();
		verifyLoginUrl();
		loginToApplication();
	}
	
	public void verifyLoginPageTitle() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	public void verifyLoginUrl() {
		Assert.assertTrue(loginPage.getLoginPageUrl().contains(Constants.LOGIN_URL_VALUE));
	}
	
	public void loginToApplication(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	public void verifyHomePageTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	
	@AfterTest
	public void tearDown() {
		loginPage.doLogout();
		driver.quit();
	}
}
