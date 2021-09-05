package com.saas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saas.utills.Constants;
import com.saas.utills.ElementUtil;



public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. private By locators:
	private By username = By.id("userid");
	private By password = By.id("password");
	private By loginButton = By.xpath("//button[contains(text(), 'Sign In')]");
	
	private By customerLogoutNameLink = By.cssSelector("a[title='Settings and Actions Menu']");
	private By signoutLink = By.linkText("Sign Out");
	private By confirmButton = By.id("Confirm");
	
	
	// 2. constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. public Page actions (methods) 

	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}

	public String getLoginPageUrl() {
		return elementUtil.getPageUrl();
	}

	public void doLogin(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
//		return new AccountsPage(driver);
	}
	 public boolean doLogout() {
	    	boolean flag = false;
	        try {
	        	elementUtil.doClick(customerLogoutNameLink);
	        	
	            if (elementUtil.waitForElementVisible(signoutLink, 10).isDisplayed())
	            {
	            	elementUtil.doClick(signoutLink);
	                System.out.println("CLICKED ON CUSTOMER");
	            }
	            elementUtil.waitForElementWithFluentWait(confirmButton, 20, 1).click();
	            System.out.println("LOGGED OUT OF FUSION APPLICATION SUCCESSFULLY");
	            flag = true;
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println("Unable to logout from the application");
	        }
			return flag;
	    }
}
